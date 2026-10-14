package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.TipTimeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            TipTimeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtSpaceScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ArtSpaceScreen(modifier: Modifier = Modifier) {
    var currentArtworkIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    val currentArtwork = artworks[currentArtworkIndex]

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = stringResource(R.string.gallery_title),
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = stringResource(
                R.string.artwork_count,
                currentArtworkIndex + 1,
                artworks.size
            ),
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary
        )

        ArtworkWall(
            artwork = currentArtwork,
            modifier = Modifier
                .fillMaxWidth()
                .widthIn(max = 480.dp)
        )

        ArtworkDescriptor(
            artwork = currentArtwork,
            modifier = Modifier
                .fillMaxWidth()
                .widthIn(max = 480.dp)
        )

        ArtworkNavigation(
            onPreviousClick = {
                currentArtworkIndex =
                    if (currentArtworkIndex > 0) {
                        currentArtworkIndex - 1
                    } else {
                        artworks.lastIndex
                    }
            },
            onNextClick = {
                currentArtworkIndex =
                    if (currentArtworkIndex < artworks.lastIndex) {
                        currentArtworkIndex + 1
                    } else {
                        0
                    }
            },
            modifier = Modifier
                .fillMaxWidth()
                .widthIn(max = 480.dp)
        )
    }
}

@Composable
fun ArtworkWall(
    artwork: Artwork,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shadowElevation = 8.dp,
        color = MaterialTheme.colorScheme.surface
    ) {
        Image(
            painter = painterResource(artwork.imageRes),
            contentDescription = stringResource(
                artwork.descriptionRes
            ),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .aspectRatio(4f / 3f)
        )
    }
}

@Composable
fun ArtworkDescriptor(
    artwork: Artwork,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.secondaryContainer
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = stringResource(artwork.titleRes),
                style = MaterialTheme.typography.headlineSmall
            )

            Text(
                text = stringResource(artwork.artistRes),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Composable
fun ArtworkNavigation(
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Button(
            onClick = onPreviousClick,
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = stringResource(R.string.previous)
            )
        }

        Button(
            onClick = onNextClick,
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = stringResource(R.string.next)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    TipTimeTheme {
        ArtSpaceScreen()
    }
}

@Preview(
    name = "Landscape Art Space",
    showBackground = true,
    widthDp = 720,
    heightDp = 400
)
@Composable
fun ArtSpaceLandscapePreview() {
    TipTimeTheme {
        ArtSpaceScreen()
    }
}