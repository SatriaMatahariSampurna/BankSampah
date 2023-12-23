package com.azhar.banksampah.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "tbl_banksampah")
@Parcelize
data class ModelDatabase(
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0,

    @ColumnInfo(name = "nama_pengguna")
    var namaPengguna: String,

    @ColumnInfo(name = "jenis_sampah")
    var jenisSampah: String,

    @ColumnInfo(name = "berat")
    var berat: Int = 0,

    @ColumnInfo(name = "harga")
    var harga: Int = 0,

    @ColumnInfo(name = "tanggal")
    var tanggal: String,

    @ColumnInfo(name = "alamat")
    var alamat: String,

    @ColumnInfo(name = "catatan")
    var catatan: String

) : Parcelable {
    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        TODO("Not yet implemented")
    }
}
