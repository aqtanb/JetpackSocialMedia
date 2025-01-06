package kz.singularity.jetpackcomposemost.presentation.users.contents

import kz.singularity.jetpackcomposemost.presentation.ui.components.InfoCard
import kz.singularity.jetpackcomposemost.presentation.ui.components.InfoRow
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kz.singularity.jetpackcomposemost.domain.model.User
import kz.singularity.presentation.R

@Composable
fun UserProfileContent(user: User) {
    val context = LocalContext.current
    val phoneNumber = user.phone.filter { it.isDigit() }.substring(0, 11)

    Column(
        modifier = Modifier.fillMaxSize().background(color = Color.White).padding(16.dp)
    ) {
        Text(
            text = user.username,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            modifier = Modifier.padding(top = 16.dp).fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        InfoCard(title = stringResource(R.string.contacts)) {
            InfoRow(
                label = stringResource(R.string.email),
                value = user.email,
                labelColor = Color.Gray,
                valueColor = Color.Blue,
                modifier = Modifier.clickable {
                    val emailIntent =
                        Intent(Intent.ACTION_SENDTO).apply {
                        data = Uri.parse("mailto:${user.email}")
                    }
                    context.startActivity(emailIntent)
                }
            )
            InfoRow(
                label = stringResource(R.string.full_name),
                value = user.name,
                labelColor = Color.Gray,
                valueColor = Color.Black
            )
            InfoRow(
                label = stringResource(R.string.phone),
                value = phoneNumber,
                labelColor = Color.Gray,
                valueColor = Color.Red,
                modifier = Modifier.clickable {
                    val phoneIntent =
                        Intent(Intent.ACTION_DIAL).apply {
                        data = Uri.parse("tel:$phoneNumber")
                    }
                    context.startActivity(phoneIntent)
                }
            )
            InfoRow(
                label = stringResource(R.string.website),
                value = user.website,
                labelColor = Color.Gray,
                valueColor = Color.Blue,
                modifier = Modifier.clickable {
                    val websiteIntent =
                        Intent(Intent.ACTION_VIEW, Uri.parse("https://${user.website}"))
                    context.startActivity(websiteIntent)
                }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        InfoCard(title = stringResource(R.string.company)) {
            InfoRow(
                label = stringResource(R.string.company_name),
                value = user.company.name,
                labelColor = Color.Gray,
                valueColor = Color.Black
            )
            InfoRow(
                label = stringResource(R.string.catch_phrase),
                value = user.company.catchPhrase,
                labelColor = Color.Gray,
                valueColor = Color.Black
            )
            InfoRow(
                label = stringResource(R.string.business_services),
                value = user.company.bs,
                labelColor = Color.Gray,
                valueColor = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        InfoCard(title = stringResource(R.string.address)) {
            InfoRow(
                label = stringResource(R.string.street),
                value = user.address.street,
                labelColor = Color.Gray,
                valueColor = Color.Black
            )
            InfoRow(
                label = stringResource(R.string.suite),
                value = user.address.suite,
                labelColor = Color.Gray,
                valueColor = Color.Black
            )
            InfoRow(
                label = stringResource(R.string.city),
                value = user.address.city,
                labelColor = Color.Gray,
                valueColor = Color.Black
            )
            InfoRow(
                label = stringResource(R.string.zipcode),
                value = user.address.zipcode,
                labelColor = Color.Gray,
                valueColor = Color.Black
            )


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = stringResource(R.string.show_on_map),
                    color = Color.Blue,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .clickable {
                            val geoUri = Uri.parse(
                                "geo:${user.address.geo.lat},${user.address.geo.lng}?q=${
                                    Uri.encode("${user.address.geo.lat},${user.address.geo.lng}")
                                }"
                            )
                            val mapIntent = Intent(Intent.ACTION_VIEW, geoUri).apply {
                                setPackage("com.google.android.apps.maps")
                            }
                            context.startActivity(mapIntent)
                        }
                )
            }
        }
    }
}


