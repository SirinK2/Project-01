package com.tuwaiq.talktome.app.homepage

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.tuwaiq.talktome.R
import com.tuwaiq.talktome.databinding.HomepageFragmentBinding
import com.tuwaiq.talktome.databinding.HomepageListItemBinding
import com.tuwaiq.talktome.domain.model.Like
import com.tuwaiq.talktome.domain.model.Post
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomepageFragment : Fragment() {



    private val viewModel by viewModels<HomepageViewModel>()
    private lateinit var binding: HomepageFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomepageFragmentBinding.inflate(layoutInflater)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getPost().observe(
            viewLifecycleOwner, {
                binding.recyclerView.adapter = HomepageAdapter(it)
            }
        )


    }

    override fun onStart() {
        super.onStart()

        binding.bottomNavigation.background = null
        binding.bottomNavigation.menu.getItem(2).isEnabled = false
        binding.addPostFloatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.postFragment)
        }
    }






    private inner class HomepageHolder(val binding: HomepageListItemBinding):RecyclerView.ViewHolder(binding.root),View.OnClickListener{
        fun bind(post: Post){
            val like = Like()
            binding.tvName.text = post.postOwner
            binding.tvDescription.text = post.postText
            post.postPhotos.forEach {
                binding.ivPic.load(it)
            }
            binding.tvLikeNumbers.text = like.likes.size.toString()


        }

        override fun onClick(v: View?) {
            if (v == binding.ivLike){

            }

        }

    }

    private inner class HomepageAdapter(val posts: List<Post>):RecyclerView.Adapter<HomepageHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomepageHolder {
            val binding = HomepageListItemBinding.inflate(
                layoutInflater,
                parent,
                false
            )
            return HomepageHolder(binding)
        }

        override fun onBindViewHolder(holder: HomepageHolder, position: Int) {
        val post = posts[position]
            holder.bind(post)

        }

        override fun getItemCount(): Int = posts.size
    }


}