package com.ericg.neatflix.data.remote.response

import com.aps.moviestmdb.data.models.Genre
import com.google.gson.annotations.SerializedName

data class GenreResponse(
    @SerializedName("genres")
    val genres: List<Genre>
)