package dev.gusriil.mindfullconnect.backend.infrastructure.roomuser

import dev.gusriil.mindfullconnect.backend.common.paging.Pagination
import dev.gusriil.mindfullconnect.backend.common.paging.PaginationResult
import dev.gusriil.mindfullconnect.backend.dtos.post.PostModel

interface RoomUserRepository {
    fun addRoomForUser(userId: Long, roomId: Long)

    fun removeRoomFromUser(userId: Long, roomId: Long)

    fun getUserRoomList(userId: Long, pagination: Pagination): PaginationResult<PostModel>

    fun isUserAlreadyJoinedRoom(userId: Long, roomId: Long): Boolean
}