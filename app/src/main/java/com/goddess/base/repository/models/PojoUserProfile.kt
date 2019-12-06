package com.goddess.base.repository.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by ShrayChona on 04-12-2018.
 */
data class PojoUserProfile(
        val code: Int = 0,
        val data: Data = Data(),
        val message: String = ""
)

data class Data(
        val accessToken: String = "",
        val user: UserProfile = UserProfile()
)

data class PojoUserUpdate(
        val code: Int = 0,
        val data: UserProfile = UserProfile(),
        val message: String = ""
)

data class UserProfile(
        var _id: String = "",
        var displayName: String = "",
        var notifications: Int = 0,
        var otp: Int = 0,
        var mobile: Phone = Phone(),
        var picture: String = "",
        var name: String = "",
        var primaryEmail: String = "",
        var primaryEmailVerified: Boolean = false,
        var secondaryEmail: String = "",
        var secondaryEmailVerified: Boolean = false,
        var conversationId: String = "",
        var biography: String = "",
        var maxVideoSize: Int = 50)

data class Phone(
        var code: String = "",
        var number: Long = 0L,
        var isVerified: Boolean = false
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readLong(),
            1 == source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(code)
        writeLong(number)
        writeInt((if (isVerified) 1 else 0))
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Phone> = object : Parcelable.Creator<Phone> {
            override fun createFromParcel(source: Parcel): Phone = Phone(source)
            override fun newArray(size: Int): Array<Phone?> = arrayOfNulls(size)
        }
    }
}

data class PojoDate(
        var day: Int = 0,
        var month: Int = 0,
        var year: Int = 0
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readInt(),
            source.readInt(),
            source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(day)
        writeInt(month)
        writeInt(year)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<PojoDate> = object : Parcelable.Creator<PojoDate> {
            override fun createFromParcel(source: Parcel): PojoDate = PojoDate(source)
            override fun newArray(size: Int): Array<PojoDate?> = arrayOfNulls(size)
        }
    }
}

