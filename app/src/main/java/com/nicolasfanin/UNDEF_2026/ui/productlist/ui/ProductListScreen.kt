package com.nicolasfanin.UNDEF_2026.ui.productlist.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nicolasfanin.UNDEF_2026.R
import com.nicolasfanin.UNDEF_2026.ui.commonscreen.ErrorScreen
import com.nicolasfanin.UNDEF_2026.ui.commonscreen.LoadingScreen
import com.nicolasfanin.UNDEF_2026.ui.productlist.viewmodel.ProductListViewModel
import com.nicolasfanin.UNDEF_2026.utils.UndefUiStates

@Composable
fun ProductListScreen(
    productListViewModel: ProductListViewModel = viewModel()
) {

    val screenState by productListViewModel.screenState.collectAsState()

    LaunchedEffect(Unit) {
        productListViewModel.getProductListScreenInfo()
    }

    when (screenState) {
        is UndefUiStates.Loading -> {
            LoadingScreen()
        }

        is UndefUiStates.Success -> {
            val screenData = (screenState as UndefUiStates.Success).screenData

            LazyColumn(
                Modifier
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                item() {
                    Text(text = screenData.title)
                }
                item() {
                    Text(text = screenData.subtitle)
                }
                items(100) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable {
                                println("Item $it")
                            }
                    ) {
                        Text(
                            modifier = Modifier
                                .border(1.dp, Color.Blue)
                                .padding(16.dp),
                            text = "Item $it"
                        )
                        Image(
                            modifier = Modifier,
                            painter = painterResource(id = R.drawable.icon_car),
                            contentDescription = null
                        )
                    }
                }
            }

        }

        is UndefUiStates.Error -> {
            val message = (screenState as UndefUiStates.Error).message
            ErrorScreen(
                message = message,
                onRetry = {
                    productListViewModel.getProductListScreenInfo()
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductListScreenPreview() {
    ProductListScreen()
}