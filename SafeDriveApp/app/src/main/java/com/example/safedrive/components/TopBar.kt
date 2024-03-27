import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.safedrive.R
import com.example.safedrive.ui.theme.gray_600

@Composable
fun TopBar(navController: NavController?, title: String) {
    Surface(
        color = gray_600,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (navController != null) {
                // Show arrow back if there is history
                IconButton(
                    onClick = { navController.popBackStack() },
                    content = {
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_back),
                            contentDescription = "Back",
                            modifier = Modifier.size(45.dp),
                            tint = Color.White
                        )
                    }
                )
            }

            Row(horizontalArrangement = Arrangement.End) {

                Image(
                    painter = painterResource(id = R.drawable.logo_white_big),
                    contentDescription = "Splash Image",
                    modifier = Modifier
                        .size(100.dp),
                )
                // Inbox icon
                IconButton(
                    onClick = { /* Handle inbox icon click */ },
                    content = {
                        Icon(
                            painter = painterResource(id = R.drawable.inbox_small),
                            contentDescription = "Inbox",
                            modifier = Modifier.size(35.dp),
                            tint = Color.White
                        )
                    }
                )

                // User icon
                IconButton(
                    onClick = { /* Handle user icon click */ },
                    content = {
                        Icon(
                            painter = painterResource(id = R.drawable.user_icon_small),
                            contentDescription = "User",
                            modifier = Modifier.size(40.dp)
                        )
                    }
                )


            }
        }
    }
}