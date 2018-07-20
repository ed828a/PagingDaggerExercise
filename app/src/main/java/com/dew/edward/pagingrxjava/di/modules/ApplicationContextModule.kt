package com.dew.edward.pagingrxjava.di.modules

import com.dew.edward.pagingrxjava.di.qualifiers.ApplicationContextQualifier
import com.dew.edward.pagingrxjava.di.scope.CustomApplicationScope
import dagger.Module
import dagger.Provides
import android.content.Context

/**
 * Created by Edward on 7/21/2018.
 */

@Module
class ApplicationContextModule(private var context: Context) {

    @Provides
    @CustomApplicationScope
    @ApplicationContextQualifier
    fun getContext() = context


}