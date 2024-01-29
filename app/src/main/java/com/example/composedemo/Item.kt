package com.example.composedemo

data class Item(
    val tracks: List<Track>,
    val artists: List<Artist>,
    val albums: List<Album>,
    val playlists: List<Playlist>,
    val shows: List<Show>,
    val episodes: List<Episode>,
)

class Track {}

class Artist {}

class Album {}

class Playlist {}

class Show {}

class Episode {}
