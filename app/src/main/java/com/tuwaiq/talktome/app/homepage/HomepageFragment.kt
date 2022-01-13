package com.tuwaiq.talktome.app.homepage

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tuwaiq.talktome.R
import com.tuwaiq.talktome.databinding.HomepageFragmentBinding
import com.tuwaiq.talktome.databinding.HomepageListItemBinding
import com.tuwaiq.talktome.domain.model.Post
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "HomepageFragment"
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
                Log.e(TAG, "onViewCreated: $it", )
            }
        )


    }

    override fun onStart() {
        super.onStart()


        binding.addPostFloatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.postFragment)
        }
    }






    private inner class HomepageHolder(val binding: HomepageListItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(post: Post){
            binding.tvName.text = post.postOwner
            binding.tvDescription.text = post.postText


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