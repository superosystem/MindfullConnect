package dev.gusriil.mindfullconnect.android.ui.main.fragment.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.gusriil.mindfullconnect.android.databinding.FragmentChatListBinding
import dev.gusriil.mindfullconnect.android.dto.post.PostModel
import dev.gusriil.mindfullconnect.android.ui.main.BaseFragmentWithBinding
import dev.gusriil.mindfullconnect.android.ui.main.adapter.ChatListAdapter
import dev.gusriil.mindfullconnect.android.ui.main.adapter.MarginItemDecoration
import dev.gusriil.mindfullconnect.android.ui.main.viewmodel.ChatViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ChatListFragment : BaseFragmentWithBinding<FragmentChatListBinding>(),
    ChatListAdapter.ChatListListener {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentChatListBinding
        get() = FragmentChatListBinding::inflate

    private val chatViewModel: ChatViewModel by sharedViewModel()
    private val chatListAdapter: ChatListAdapter by lazy {
        ChatListAdapter(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        chatViewModel.getAllChatsList()
        binding.rvChatList.apply {
            adapter = chatListAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            addItemDecoration(
                MarginItemDecoration(24)
            )
        }
        chatViewModel.chats.observe(viewLifecycleOwner) { chats ->
            chatListAdapter.submitList(chats.map { it.copy() })
        }
    }

    override fun onOpenChat(post: PostModel) {
        findNavController().navigate(
            ChatListFragmentDirections.actionNavigationChatToNavigationChatMessage(
                post
            )
        )
    }
}