package dev.gusriil.mindfullconnect.android.repository.chat

import dev.gusriil.mindfullconnect.android.dto.message.MessageModel
import dev.gusriil.mindfullconnect.android.dto.message.MessageResponseModel
import dev.gusriil.mindfullconnect.android.dto.post.PostResponseModel
import dev.gusriil.mindfullconnect.android.network.FormattedNetworkClientException
import dev.gusriil.mindfullconnect.android.network.WebSocketBuilder
import dev.gusriil.mindfullconnect.android.utils.Result
import io.ktor.client.call.body
import io.ktor.client.plugins.websocket.webSocketSession
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.url
import io.ktor.websocket.Frame
import io.ktor.websocket.WebSocketSession
import io.ktor.websocket.close
import io.ktor.websocket.readText
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.isActive
import kotlinx.serialization.json.Json

class ChatRepositoryImpl(private val client: WebSocketBuilder) : ChatRepository {
    private var socket: WebSocketSession? = null

    override suspend fun initSession(room: Long): Result<Boolean> {
        return try {
            socket = client.socket.webSocketSession {
                url(ChatRepository.Endpoints.CHAT_SOCKET.url + "/$room")
            }
            Result.Success(socket?.isActive == true)
        } catch (exception: FormattedNetworkClientException) {
            Result.Error(message = exception.formattedErrorMessage)
        } catch (exception: Exception) {
            Result.Error("Server or network error")
        }
    }

    override suspend fun sendMessage(message: String) {
        try {
            socket?.send(Frame.Text(message))
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    override fun observeIncomingMessages(): Flow<MessageModel> {
        return try {
            socket?.incoming?.receiveAsFlow()?.filter { it is Frame.Text }
                ?.map {
                    val json = (it as? Frame.Text)?.readText() ?: ""
                    Json.decodeFromString(json)
                } ?: flow { }
        } catch (ex: Exception) {
            flow { }
        }
    }

    override suspend fun closeSession() {
        socket?.close()
    }

    override suspend fun getAllRoomMessages(roomId: Long): Result<MessageResponseModel> {
        return try {
            Result.Success(
                client.socket.get(ChatRepository.Endpoints.GET_ALL_ROOM_MESSAGES.url + "/$roomId")
                    .body()
            )
        } catch (exception: FormattedNetworkClientException) {
            Result.Error(exception.formattedErrorMessage)
        } catch (exception: Exception) {
            Result.Error("Server or network error")
        }
    }

    override suspend fun getAllChats(): Result<PostResponseModel> {
        return try {
            Result.Success(
                client.socket.get(ChatRepository.Endpoints.GET_ALL_ROOMS.url)
                    .body()
            )
        } catch (exception: FormattedNetworkClientException) {
            Result.Error(exception.formattedErrorMessage)
        } catch (exception: Exception) {
            Result.Error("Server or network error")
        }
    }

    override suspend fun addUserToRoom(roomId: Long): Result<Boolean> {
        return try {
            Result.Success(
                client.socket.post(ChatRepository.Endpoints.JOIN_LEAVE_ROOM.url + "/$roomId")
                    .body()
            )
        } catch (exception: FormattedNetworkClientException) {
            Result.Error(exception.formattedErrorMessage)
        } catch (exception: Exception) {
            Result.Error("Server or network error")
        }
    }

    override suspend fun removeUserFromRoom(roomId: Long): Result<Boolean> {
        return try {
            Result.Success(
                client.socket.delete(ChatRepository.Endpoints.JOIN_LEAVE_ROOM.url + "/$roomId")
                    .body()
            )
        } catch (exception: FormattedNetworkClientException) {
            Result.Error(exception.formattedErrorMessage)
        } catch (exception: Exception) {
            Result.Error("Server or network error")
        }
    }
}