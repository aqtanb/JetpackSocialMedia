package kz.singularity.jetpackcomposemost.domain.model

data class Todo (
    val usedId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
)