@file:Suppress("ImplicitThis", "ExplicitThis")

package com.azhar.banksampah.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.azhar.banksampah.database.DatabaseClient.Companion.getInstance
import com.azhar.banksampah.database.dao.DatabaseDao
import com.azhar.banksampah.model.ModelDatabase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * Created by Azhar Rivaldi on 6-12-2021
 * Youtube Channel : https://bit.ly/2PJMowZ
 * Github : https://github.com/AzharRivaldi
 * Twitter : https://twitter.com/azharrvldi_
 * Instagram : https://www.instagram.com/azhardvls_
 * LinkedIn : https://www.linkedin.com/in/azhar-rivaldi
 */

@Suppress("ExplicitThis")
class RiwayatViewModel(application: Application) : AndroidViewModel(application) {

    lateinit var totalSaldo: LiveData<Int>
    var dataBank: LiveData<List<ModelDatabase>>
    private var databaseDao: DatabaseDao?

    fun deleteDataById(uid: Int) {
        Completable.fromAction {
            this.databaseDao?.deleteSingleData(uid)
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

    init {
        this.databaseDao = getInstance(application)?.appDatabase?.databaseDao()
        this.dataBank =
            (databaseDao?.getAll() ?: this.totalSaldo) as LiveData<List<ModelDatabase>> = this.databaseDao!!.getSaldo()
    }

}