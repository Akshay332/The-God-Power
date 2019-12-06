//package com.app_knit.base.repository.interactors
//
//import com.app_knit.base.repository.networkrequest.NetworkRequestCallbacks
//import com.app_knit.base.repository.networkrequest.RestClient
//import com.app_knit.base.utils.ApplicationGlobal
//import io.reactivex.android.schedulers.AndroidSchedulers
//import io.reactivex.disposables.Disposable
//import io.reactivex.observers.DisposableObserver
//import io.reactivex.schedulers.Schedulers
//import okhttp3.MultipartBody
//import okhttp3.RequestBody
//import retrofit2.Response
//
///**
// * @author ShrayChona@gmail.com
// * @since 20/3/19
// */
//class SignUpInteractor {
//
//    fun userSignup(userData: RequestBody?, image: MultipartBody.Part?, networkRequestCallbacks: NetworkRequestCallbacks): Disposable {
//        return RestClient.get().userSignup(ApplicationGlobal.accessToken, userData, image)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(object : DisposableObserver<Response<*>>() {
//                    override fun onNext(response: Response<*>) {
//                        networkRequestCallbacks.onSuccess(response)
//                    }
//
//                    override fun onError(t: Throwable) {
//                        networkRequestCallbacks.onError(t)
//                    }
//
//                    override fun onComplete() {
//
//                    }
//                })
//    }
//
//}