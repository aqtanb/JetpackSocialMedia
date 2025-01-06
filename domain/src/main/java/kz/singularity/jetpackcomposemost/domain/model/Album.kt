package kz.singularity.jetpackcomposemost.domain.model

data class Album (
    // TODO: val photos: List<Photo>, val user: User
    val userId: Int,
    val id: Int,
    val title: String
)