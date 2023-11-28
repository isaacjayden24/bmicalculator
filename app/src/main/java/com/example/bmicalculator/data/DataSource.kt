
package com.example.bmicalculator.data

import com.example.bmicalculator.R
import com.example.bmicalculator.model.Healthy

object DataSource {
 val tips: List<Healthy> = listOf(
  Healthy(
   "Balanced Diet:",
   "Users are encouraged to adopt a balanced diet, which includes a richness of fruits, vegetables," +
           " whole grains, lean proteins, and healthy fats. " +
           "The consumption of a balanced diet is recommended as it provides essential nutrients and" +
           " contributes to the maintenance of a healthy weight."
  ),

  Healthy(
   "Portion Control:",
   "Users are advised to incorporate portion control practices to prevent overeating and to be mindful of " +
           "their food intake, even when consuming nutritious foods."
  ),

  Healthy(
   "Stay Hydrated:",
   "Users are reminded to ensure that an adequate amount of water is consumed throughout the day. " +
           "The maintenance of hydration levels is considered crucial for overall health and " +
           "is associated with appetite control."
  ),

  Healthy(
   "Regular Exercise:",
   "Users are encouraged to participate in regular physical activities that are enjoyable to them," +
           " such as walking, swimming, dancing, or cycling. The engagement in consistent exercise" +
           " is acknowledged as a contributor to the maintenance of a healthy BMI and overall well-being."
  )

  // Add more Healthy objects as needed
 )
}
