package dev.gusriil.mindfullconnect.backend.infrastructure.message

import dev.gusriil.mindfullconnect.backend.common.paging.Pagination
import dev.gusriil.mindfullconnect.backend.common.paging.PaginationResult
import dev.gusriil.mindfullconnect.backend.dtos.chat.MessageModel

interface MessageRepository {
    fun createMessage(message: MessageModel)

    fun getAllMessageByRoomId(roomId: Long, pagination: Pagination): PaginationResult<MessageModel>
}