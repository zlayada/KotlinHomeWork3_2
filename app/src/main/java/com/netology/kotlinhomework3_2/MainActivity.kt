package com.netology.kotlinhomework3_2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var post = Post(
        1,
        "Джон Смит",
        "Самое первое сообщение в этой социальной сети. Где отображаются переносы слов, но не более ограниченных строк.",
        "18 ноября 2019",
        false,
        false,
        false,
        98,
        76,
        54
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView_data.text = post.created
        textView_text_note.text = post.content

        textView_counte_share.text = post.shareCounter.toString()
        textView_counte_commit.text = post.commentCounter.toString()
        textView_counte_like.text = post.likedCounter.toString()
        textView_author.text = post.author


    }

    fun onClick(view: View){

        /*val massage = Toast.makeText (this, "Click", Toast.LENGTH_SHORT)
        massage.show()*/

        when (view) {
            imageBtn_like -> {
                if (post.likedByMe == false) {
                    imageBtn_like.setImageResource(R.drawable.ic_favorite_red_24dp)
                    textView_counte_like.setTextColor(Color.RED)
                    post.likedByMe = true

                    // "Подсчет" лайков и обновление значения на экране
                    post.likedCounter +=1
                    textView_counte_like.text = post.likedCounter.toString()
                } else {
                    imageBtn_like.setImageResource(R.drawable.ic_favorite_black_24dp)
                    textView_counte_like.setTextColor(Color.GRAY)
                    post.likedByMe = false
                }
            }
            imageBtn_commit -> {
                if (post.CommentdByMe == false) {
                    imageBtn_commit.setImageResource(R.drawable.ic_mode_comment_red_24dp)
                    textView_counte_commit.setTextColor(Color.RED)
                    post.CommentdByMe = true
                } else {
                    imageBtn_commit.setImageResource(R.drawable.ic_mode_comment_black_24dp)
                    textView_counte_commit.setTextColor(Color.GRAY)
                    post.CommentdByMe = false
                }
            }
            imageBtn_share -> {
                if (post.ShareByMe == false) {
                    imageBtn_share.setImageResource(R.drawable.ic_share_red_24dp)
                    textView_counte_share.setTextColor(Color.RED)
                    post.ShareByMe = true
                } else {
                    imageBtn_share.setImageResource(R.drawable.ic_share_black_24dp)
                    textView_counte_share.setTextColor(Color.GRAY)
                    post.ShareByMe = false
                }
            }
        }
    }
}
