package com.dew.edward.pagingrxjava.di.modules

import android.content.Context
import com.dew.edward.pagingrxjava.di.qualifiers.ApplicationContextQualifier
import com.dew.edward.pagingrxjava.di.scope.CustomApplicationScope
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient


/**
 * Created by Edward on 7/21/2018.
 */

@Module(includes = [NetworkModule::class])
class PicassoModule {

    @Provides
    @CustomApplicationScope
    fun getOkHttp3Downloader(okHttpClient: OkHttpClient) = OkHttp3Downloader(okHttpClient)

    @Provides
    @CustomApplicationScope
    fun getPicasso(@ApplicationContextQualifier context: Context, okHttpDownloader: OkHttp3Downloader): Picasso {
        return Picasso.Builder(context)
                .downloader(okHttpDownloader)
                .build()
    }
}
