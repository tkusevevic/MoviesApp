package com.tkusevic.moviesapp.data.model

import com.google.firebase.database.IgnoreExtraProperties

/**
 * Created by tkusevic on 14.02.2018..
 */
@IgnoreExtraProperties
class User (val id : String,
            val email : String,
            var userDisplayName : String,
            var description : String,
            var moviesDescription : String)