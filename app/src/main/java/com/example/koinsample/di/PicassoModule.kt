package com.example.koinsample.di

import android.content.Context
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val picassoModule = module {
    single {
        val downloader = okHttp3Downloader(get())
        getPicasso(androidContext(), downloader)
    }

}

private fun okHttp3Downloader(client: OkHttpClient) = OkHttp3Downloader(client)


private fun getPicasso(context: Context, downloader: OkHttp3Downloader) = Picasso.Builder(context)
    .downloader(downloader)
    .build()