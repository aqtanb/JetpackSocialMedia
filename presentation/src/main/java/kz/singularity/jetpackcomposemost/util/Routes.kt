package kz.singularity.jetpackcomposemost.util

object Routes {
    const val POSTS = "posts"
    const val POST_DETAIL = "posts/postDetail/{postId}/{userId}"
    const val COMMENTS = "posts/postDetail/comments/{postId}"
    const val ALBUMS = "albums"
    const val PHOTOS = "albums/photos/{albumId}/{username}"
    const val USERS = "users"
    const val USER_PROFILE = "users/userProfile/{userId}"
    const val PROFILE = "profile"
    const val TODOS = "profile/todos/{userId}"
}
