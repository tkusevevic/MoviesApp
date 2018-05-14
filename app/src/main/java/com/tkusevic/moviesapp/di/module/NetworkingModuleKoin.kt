package com.tkusevic.moviesapp.di.module

import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext

/**
 * Created by tkusevic on 08.04.2018..
 */
val NetworkingModuleKoin : Module = applicationContext{

    bean { fun baseUrl(): String = "http://api.themoviedb.org/" }
}