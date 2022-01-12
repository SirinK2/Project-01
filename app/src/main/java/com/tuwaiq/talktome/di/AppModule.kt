package com.tuwaiq.talktome.di

import com.tuwaiq.talktome.data.repo.AuthRepoImpl
import com.tuwaiq.talktome.data.repo.PostRepoImpl
import com.tuwaiq.talktome.data.repo.UserRepoImpl
import com.tuwaiq.talktome.domain.repo.AuthRepo
import com.tuwaiq.talktome.domain.repo.PostRepo
import com.tuwaiq.talktome.domain.repo.UserRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideAuthRepo():AuthRepo = AuthRepoImpl()


    @Singleton
    @Provides
    fun provideUserRepo():UserRepo = UserRepoImpl()

    @Singleton
    @Provides
    fun providePostRepo(): PostRepo = PostRepoImpl()

}