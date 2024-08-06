package com.example.photohub.data.user

import com.example.photohub.PersistenceAdapter
import com.example.photohub.data.user.repository.UserRepository
import com.example.photohub.usecase.global.model.MappingProvider
import com.example.photohub.usecase.user.model.UserModel
import com.example.photohub.usecase.user.model.impl.UserModelImpl
import com.example.photohub.usecase.user.port.out.persistence.ExistUserPort
import com.example.photohub.usecase.user.port.out.persistence.FindUserPort
import com.example.photohub.usecase.user.port.out.persistence.SaveUserPort

@PersistenceAdapter
class UserPersistenceAdapter(
    private val userRepository: UserRepository,
    private val mappingProvider: MappingProvider
) : SaveUserPort,
    FindUserPort,
    ExistUserPort {

    override fun save(user: UserModel): UserModel =
        UserModelImpl(
            userRepository.save((user as UserModelImpl).userJpaEntity),
            mappingProvider
        )

    override fun findByUsername(username: String): UserModel? =
        userRepository.findByUsername(username)?.let { UserModelImpl(it, mappingProvider) }

    override fun existByUserName(username: String): Boolean =
        userRepository.existsByUsername(username)
}