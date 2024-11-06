package kz.singularity.jetpackcomposemost.presentation.profile.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kz.singularity.jetpackcomposemost.domain.model.Todo
import kz.singularity.jetpackcomposemost.domain.model.User
import kz.singularity.jetpackcomposemost.domain.use_case.GetTodosUseCase
import kz.singularity.jetpackcomposemost.domain.use_case.GetUsersUseCase
import javax.inject.Inject

data class ProfileState(
    val users: List<User> = emptyList(),
    val todos: List<Todo> = emptyList(),
    val isLoadingUsers: Boolean = true,
    val isLoadingTodos: Boolean = true,
)

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase,
    private val getTodosUseCase: GetTodosUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(ProfileState())
    val state: StateFlow<ProfileState> = _state

    init {
        loadUsers()
        loadTodos()
    }

    private fun loadUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            val users = getUsersUseCase.invoke()
            _state.value = _state.value.copy(users = users, isLoadingUsers = false)
        }
    }

    private fun loadTodos() {
        viewModelScope.launch(Dispatchers.IO) {
            val todos = getTodosUseCase.invoke()
            _state.value = _state.value.copy(todos = todos, isLoadingTodos = false)
        }
    }
}
