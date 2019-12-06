package com.goddess.base.utils

import android.os.Environment

/**
 * Created by ShrayChona on 03-10-2018.
 */
object Constants {

    const val APP_NAME = "BASE"

    const val CONTENT_TYPE = "application/json"
//    const val COUNTRY_CODE = "+91"
    const val DEVICE_TYPE = "android"

    // Media Constants
    const val LOCAL_FILE_PREFIX = "file://"
    private val LOCAL_STORAGE_BASE_PATH_FOR_MEDIA = Environment
            .getExternalStorageDirectory().toString() + "/" + APP_NAME
    val LOCAL_STORAGE_BASE_PATH_FOR_USER_MEDIA = "$LOCAL_STORAGE_BASE_PATH_FOR_MEDIA/User/Media/"
    val LOCAL_STORAGE_BASE_PATH_FOR_USER_PHOTOS = "$LOCAL_STORAGE_BASE_PATH_FOR_MEDIA/User/Photos/"
    val LOCAL_STORAGE_BASE_PATH_FOR_USER_POST_PHOTOS = "$LOCAL_STORAGE_BASE_PATH_FOR_MEDIA/User/Post/"
    val LOCAL_STORAGE_BASE_PATH_FOR_USER_POST_VIDEOS = "$LOCAL_STORAGE_BASE_PATH_FOR_MEDIA/User/Videos/"
    val LOCAL_STORAGE_BASE_PATH_FOR_USER_AUDIO = "$LOCAL_STORAGE_BASE_PATH_FOR_MEDIA/User/Audios/"

}