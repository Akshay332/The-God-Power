package com.goddess.base.views.fragments

import android.Manifest
import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.provider.MediaStore
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.goddess.base.BuildConfig
import com.goddess.base.R
import com.goddess.base.utils.GeneralFunctions
import com.goddess.base.utils.GetSampledImage
import com.goddess.base.views.activities.inflate
import kotlinx.android.synthetic.main.show_picture_options_bottom_sheet.view.*
import kotlinx.android.synthetic.main.show_video_options_bottom_sheet.view.*
import java.io.File

/**
 * Created by ShrayChona on 03-10-2018.
 * @description extend this class for basic fragment with support of uploading images
 */
abstract class BasePictureOptionsFragment : BaseFragment(), GetSampledImage.SampledImageAsyncResp {

    companion object {
        const val GALLERY_REQUEST = 234
        const val CAMERA_REQUEST = 23
        const val READ_EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE = 1
        const val CAMERA_PERMISSION_REQUEST_CODE = 2
    }


    var picturePath: String? = null
    var imagesDirectory: String? = null
    var isVideo: Boolean = false
    private var isCameraOptionSelected: Boolean = false

    override fun init() {
        setData()
    }

    fun showPictureOptionsBottomSheet(isShowSelectionOptions: Boolean, imagesDirectory: String, isVideo: Boolean) {
        val bottomSheetDialog = com.google.android.material.bottomsheet.BottomSheetDialog(activityContext)
        val view = (view as ViewGroup).inflate(layoutRes = R.layout.show_picture_options_bottom_sheet)

        view.tvCamera.setOnClickListener {
            checkForPermissions(isShowSelectionOptions, true, imagesDirectory, isVideo)
            bottomSheetDialog.dismiss()
        }
        view.tvGallery.setOnClickListener {
            checkForPermissions(isShowSelectionOptions, false, imagesDirectory, isVideo)
            bottomSheetDialog.dismiss()
        }
        view.tvCancel.setOnClickListener { bottomSheetDialog.dismiss() }

        bottomSheetDialog.setContentView(view)
        bottomSheetDialog.show()
    }

    private fun showVideoOptionsBottomSheet(isCameraOptionSelected: Boolean, imagesDirectory: String) {
        val bottomSheetDialog = com.google.android.material.bottomsheet.BottomSheetDialog(activityContext)
        val view = (view as ViewGroup).inflate(layoutRes = R.layout.show_video_options_bottom_sheet)
        val tvVideo = view.findViewById<TextView>(R.id.tvVideo)
        val tvPhoto = view.findViewById<TextView>(R.id.tvPhoto)
        if (isCameraOptionSelected) {
            tvVideo.text = getString(R.string.take_video)
            tvPhoto.text = getString(R.string.take_still_photo)
        } else {
            tvVideo.text = getString(R.string.open_video_gallery)
            tvPhoto.text = getString(R.string.open_image_gallery)
        }
        view.tvVideo.setOnClickListener {
            this.isVideo = true
            if (isCameraOptionSelected) {
                startCameraIntent()
            } else {
                openGallery()
            }
            bottomSheetDialog.dismiss()
        }
        view.tvPhoto.setOnClickListener {
            this.isVideo = false
            if (isCameraOptionSelected) {
                startCameraIntent()
            } else {
                openGallery()
            }
            bottomSheetDialog.dismiss()
        }
//        view.tvCancelVideo.setOnClickListener { bottomSheetDialog.dismiss() }

        bottomSheetDialog.setContentView(view)
        bottomSheetDialog.show()
    }

    fun checkForPermissions(isShowSelectionOptions: Boolean, isCameraOptionSelected: Boolean, imagesDirectory: String, isVideo: Boolean) {
        this.isCameraOptionSelected = isCameraOptionSelected
        this.imagesDirectory = imagesDirectory
        this.isVideo = isVideo

        if (isPermissionGrantedForReadExtStorage) {
            if (isShowSelectionOptions)
                if (isVideo) {
                    showVideoOptionsBottomSheet(isCameraOptionSelected, imagesDirectory)
                } else {
                    if (isCameraOptionSelected) {
                        startCameraIntent()
                    } else {
                        openGallery()
                    }
                }
            else {
                if (isCameraOptionSelected) {
                    startCameraIntent()
                } else {
                    openGallery()
                }
            }
        } else {
            requestPermissionForReadExtStorage()
        }
    }

    private fun openGallery() {
        val intent = if (isVideo) Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI)
        else Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, GALLERY_REQUEST)
    }

    private fun startCameraIntent() {
        val takePictureIntent = if (isVideo) Intent(MediaStore.ACTION_VIDEO_CAPTURE)
        else Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            val file = if (isVideo) GeneralFunctions.setUpVideoFile(imagesDirectory!!)
            else GeneralFunctions.setUpImageFile(imagesDirectory!!)
            picturePath = file!!.absolutePath

            val outputUri = FileProvider
                    .getUriForFile(activity!!, BuildConfig.APPLICATION_ID + ".provider", file)
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, outputUri)
            takePictureIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION)

            when {
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ->
                    takePictureIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
                else -> {
                    val resInfoList = activity!!.packageManager
                            .queryIntentActivities(takePictureIntent,
                                    PackageManager.MATCH_DEFAULT_ONLY)
                    resInfoList
                            .map { it.activityInfo.packageName }
                            .forEach {
                                activity!!.grantUriPermission(it, outputUri,
                                        Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
                            }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            picturePath = null
        }

        startActivityForResult(takePictureIntent, CAMERA_REQUEST)
    }

    private val isPermissionGrantedForReadExtStorage: Boolean
        get() = (ContextCompat.checkSelfPermission(activityContext,
                Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) &&
                (ContextCompat.checkSelfPermission(activityContext,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)

    private fun requestPermissionForReadExtStorage() {
        if (shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE)) {
            showAlertDialog(getString(R.string.storage_permission_needed),
                    DialogInterface.OnClickListener { _, _ ->
                        requestRunTimePermission(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE),
                                READ_EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE)
                    }, null)
        } else {
            requestRunTimePermission(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    READ_EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE)
        }
    }

    private fun showAlertDialog(message: String,
                                okListener: DialogInterface.OnClickListener,
                                cancelListener: DialogInterface.OnClickListener?) {
        AlertDialog.Builder(activityContext)
                .setMessage(message)
                .setPositiveButton(getString(R.string.ok), okListener)
                .setNegativeButton(getString(R.string.cancel), cancelListener)
                .create()
                .show()
    }

    private fun requestRunTimePermission(permissions: Array<String>,
                                         requestCode: Int) {
        requestPermissions(permissions, requestCode)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>,
                                            grantResults: IntArray) {
        when (requestCode) {
            READ_EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE ->
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (isCameraOptionSelected) {
                        startCameraIntent()
                    } else {
                        openGallery()
                    }
                } else {
                    showMessage(R.string.enable_storage_permission, null,
                            false)
                }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && (requestCode == GALLERY_REQUEST ||
                        requestCode == CAMERA_REQUEST)) {
            var isGalleryImage = false
            if (requestCode == GALLERY_REQUEST) {
                val selectedImage = data!!.data
                val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)
                val cursor = activity!!.contentResolver.query(selectedImage,
                        filePathColumn, null, null, null)
                cursor!!.moveToFirst()
                val columnIndex = cursor.getColumnIndex(filePathColumn[0])
                picturePath = cursor.getString(columnIndex)
                cursor.close()
                isGalleryImage = true
            }

            if (isVideo) onGettingVideoUri(picturePath!!)
            else GetSampledImage(this).execute(picturePath, imagesDirectory,
                    isGalleryImage.toString(),
                    resources.getDimension(R.dimen.user_image_downsample_size).toInt().toString())
        }
    }

    override fun onSampledImageAsyncPostExecute(file: File) {
        onGettingImageFile(file)
    }

    abstract fun setData()

    abstract fun onGettingImageFile(file: File)

    abstract fun onGettingVideoUri(uriString: String)

}