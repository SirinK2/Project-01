package com.tuwaiq.talktome.app.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.tuwaiq.talktome.databinding.HomepageListItemBinding
import com.tuwaiq.talktome.databinding.ProfileFragmentBinding
import com.tuwaiq.talktome.domain.model.Post
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {



    private val viewModel by viewModels<ProfileViewModel>()

    lateinit var binding: ProfileFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProfileFragmentBinding.inflate(layoutInflater)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getPost().observe(
            viewLifecycleOwner,{
                binding.recyclerView.adapter = ProfileAdapter(it)
            }
        )

    }


    private inner class ProfileHolder(val binding: HomepageListItemBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(post: Post){
            binding.tvName.text = post.postOwner
            binding.tvDescription.text = post.postText
            post.postPhotos.forEach {
                binding.ivPic.load(it)
            }

        }


    }

    private inner class ProfileAdapter(val posts: List<Post>):RecyclerView.Adapter<ProfileHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileHolder {
            val binding = HomepageListItemBinding.inflate(layoutInflater,parent,false)
            return ProfileHolder(binding)
        }

        override fun onBindViewHolder(holder: ProfileHolder, position: Int) {
            val post = posts[position]
            holder.bind(post)
        }

        override fun getItemCount(): Int = posts.size
    }


}