package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ui.screens.GameScreen
import com.example.ui.screens.LevelSelectScreen
import com.example.ui.theme.MyApplicationTheme
import com.example.ui.viewmodel.GameViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                WordGuessApp()
            }
        }
    }
}

@Composable
fun WordGuessApp(
    viewModel: GameViewModel = viewModel()
) {
    val activeScreen by viewModel.activeScreen.collectAsStateWithLifecycle()
    val playerStats by viewModel.playerStats.collectAsStateWithLifecycle()
    val allLevelRecords by viewModel.allLevelRecords.collectAsStateWithLifecycle()

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        when (activeScreen) {
            GameViewModel.Screen.GAME -> {
                GameScreen(
                    viewModel = viewModel,
                    modifier = Modifier.padding(innerPadding)
                )
            }
            GameViewModel.Screen.LEVEL_SELECT -> {
                BackHandler {
                    viewModel.navigateTo(GameViewModel.Screen.GAME)
                }
                LevelSelectScreen(
                    currentUnlockedLevel = playerStats.currentLevel,
                    levelRecords = allLevelRecords,
                    onSelectLevel = { levelNum ->
                        viewModel.loadLevel(levelNum)
                        viewModel.navigateTo(GameViewModel.Screen.GAME)
                    },
                    onBack = {
                        viewModel.navigateTo(GameViewModel.Screen.GAME)
                    },
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}
