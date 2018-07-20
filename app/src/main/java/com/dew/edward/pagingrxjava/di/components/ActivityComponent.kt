package com.dew.edward.pagingrxjava.di.components

import com.dew.edward.pagingrxjava.activity.MainActivity
import com.dew.edward.pagingrxjava.di.scope.ActivityScope
import dagger.Component


/**
 * Created by Edward on 7/21/2018.
 */

@ActivityScope
@Component(dependencies = [MyApplicationComponent::class])
interface ActivityComponent : MyApplicationComponent {

    fun inject(mainActivity: MainActivity)
}