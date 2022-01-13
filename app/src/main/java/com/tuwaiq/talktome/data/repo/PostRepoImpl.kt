package com.tuwaiq.talktome.data.repo

import android.net.Uri
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.tuwaiq.talktome.domain.model.Post
import com.tuwaiq.talktome.domain.repo.PostRepo
import kotlinx.coroutines.tasks.await
import java.util.*

private const val TAG = "PostRepoImpl"
private const val POST_COLLECTION = "post"
private const val LIKE_COLLECTION = "like"
private const val COMMENT_COLLECTION = "comment"

class PostRepoImpl:PostRepo {

    private val postCollectionRef = Firebase.firestore.collection(POST_COLLECTION)
    private val likeCollectionRef = Firebase.firestore.collection(LIKE_COLLECTION)
    private val commentCollectionRef = Firebase.firestore.collection(COMMENT_COLLECTION)


    override suspend fun addPost(post: Post) {

      val ref = postCollectionRef.document()
        post.postId = ref.id
        ref.set(post)
        Log.e(TAG, "addPost: add", )

    }


    override suspend fun getPosts(): List<Post> =
        postCollectionRef
            .get()
            .await()
            .toObjects(Post::class.java)







    override suspend fun uploadPhotos(uri: List<Uri>): List<String> {
        val photosUri = mutableListOf<String>()
        uri.forEach {
            val fileName = "IMG_${UUID.randomUUID()}.jpg"
            val photoRef = Firebase.storage.reference.child("post/$fileName")
            val url = photoRef.putFile(it).continueWithTask { task ->
                if (!task.isSuccessful){
                    task.exception?.let { exp ->
                        throw exp
                    }
                }
                photoRef.downloadUrl

            }.await()
            photosUri += url.toString()
        }
        return photosUri
    }


}