package com.example.roomdatabasepractice.ui.product_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.roomdatabasepractice.data.entity.Product
import com.example.roomdatabasepractice.util.UiEvent

@Composable
fun ProductListScreen(
    viewModel : ProductListViewModel = hiltViewModel()
) {
    val productList = viewModel.productList.collectAsState(initial = emptyList())
    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message,
                        actionLabel = event.action
                    )
                }
                else -> Unit
            }
        }
    }

    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier.padding(8.dp)
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    TextField(
                        value = viewModel.name,
                        onValueChange = {viewModel.onEvent(ProductListEvent.OnNameChanged(it))},
                        label = { Text(text = "Name") }
                    )
                    TextField(
                        value = viewModel.description,
                        onValueChange = {viewModel.onEvent(ProductListEvent.OnDescriptionChanged(it))},
                        label = { Text(text = "Description") }
                    )
                    TextField(
                        value = viewModel.type,
                        onValueChange = {viewModel.onEvent(ProductListEvent.OnTypeChanged(it))},
                        label = { Text(text = "Type") }
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Button(
                        onClick = {
                            viewModel.onEvent(ProductListEvent.OnClickInsertProductButton)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    ) {
                        Text(text = "Insert")
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = {
                            viewModel.onEvent(ProductListEvent.OnClickDeleteAllProductsButton)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    ) {
                        Text(
                            text = "Delete All",
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
            Divider(
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .height(2.dp),
                color = Color.Black
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items (productList.value) { product ->
                    ProductListCard(
                        product = product,
                        onClickUpdateProductButton = {
                            viewModel.onEvent(ProductListEvent.OnClickUpdateProductButton(product))
                        },
                        onClickDeleteProductButton = {
                            viewModel.onEvent(ProductListEvent.OnClickDeleteProductButton(product))
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun ProductListCard(
    product: Product,
    onClickUpdateProductButton: () -> Unit,
    onClickDeleteProductButton: () -> Unit,
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color.LightGray,
        elevation = 12.dp
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(8.dp)
                    .height(IntrinsicSize.Min)
            ) {
                Text(
                    text = product.name,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(6f)
                )
                Text(
                    text = product.type,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.weight(4f),
                    textAlign = TextAlign.Right
                )
                IconButton(
                    onClick = onClickUpdateProductButton,
                    modifier = Modifier
                        .aspectRatio(
                            ratio = 1f,
                            matchHeightConstraintsFirst = true
                        )
                        .fillMaxSize()
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Update"
                    )
                }
                IconButton(
                    onClick = onClickDeleteProductButton,
                    modifier = Modifier
                        .aspectRatio(
                            ratio = 1f,
                            matchHeightConstraintsFirst = true
                        )
                        .fillMaxSize()
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete"
                    )
                }
            }
            Text(
                text = product.description,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}