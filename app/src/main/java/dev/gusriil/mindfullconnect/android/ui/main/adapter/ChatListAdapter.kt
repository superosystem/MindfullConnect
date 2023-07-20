package dev.gusriil.mindfullconnect.android.ui.main.adapter

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.gusriil.mindfullconnect.android.R
import dev.gusriil.mindfullconnect.android.databinding.ItemChatBinding
import dev.gusriil.mindfullconnect.android.dto.post.PostModel

class ChatListAdapter(private val listener: ChatListListener) :
    ListAdapter<PostModel, ChatListAdapter.PostViewHolder>(DiffCallbackPost()) {

    interface ChatListListener {
        fun onOpenChat(post: PostModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            ItemChatBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class PostViewHolder(private val binding: ItemChatBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(post: PostModel) = with(binding) {
            binding.tvUsername.text =
                if (TextUtils.isEmpty(post.user?.username)) "admin" else post.user?.username
            tvTitle.text = post.title
            itemView.setOnClickListener {
                listener.onOpenChat(post)
            }
            Glide.with(ivProfileIcon).load(post.user?.avatarUrl).error(R.drawable.avatar_static)
                .into(binding.ivProfileIcon)
        }
    }
}