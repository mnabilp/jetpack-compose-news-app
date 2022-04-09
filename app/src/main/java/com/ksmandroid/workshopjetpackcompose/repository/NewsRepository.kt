package com.ksmandroid.workshopjetpackcompose.repository

import com.ksmandroid.workshopjetpackcompose.model.News
import kotlin.reflect.KProperty

object NewsRepository {
    fun getAll(): List<News> {
        return listOf(
            News(
                id = 1,
                imageUrl = "https://variety.com/wp-content/uploads/2022/04/TheDropout.Elizabeth.smiling-phone-CROP.jpg?w=1024",
                title = "Secrets of ‘The Dropout’ Finale: Amanda Seyfried, Elizabeth Meriwether Tell All About ‘Lizzy’ – and That Terrifying Scream",
                description = "SPOILER ALERT: This piece contains spoilers for “Lizzy,” the finale of “The Dropout,” which premiered April 7 Hulu. When Elizabeth Meriwether was first planning “The Dropout” — her Hulu adaptation of the popular ABC News podcast of the same name, which chroni…",
                author = "Kate Aurthur",
                date = "2022-04-07T11:00:39Z"
            ),
            News(
                id = 2,
                imageUrl = "https://media.wired.com/photos/624de4f773b639a714b7f361/191:100/w_1280,c_limit/How-to-Take-Care-of-Your-Electric-Vehicle-Battery-Gear-1202275839.jpg",
                title = "How to Take Care of Your Electric Vehicle Battery",
                description = "We asked a battery expert to answer all your questions about maximizing every charge.",
                author = "Omar L. Gallaga",
                date = "2022-04-07T11:00:00Z"
            ),
            News(
                id = 3,
                imageUrl = "https://images.mktw.net/im-520127/social",
                title = "Need to Know: The stock market is behaving a lot like it did during the Iraq War. Here’s the future if the pattern continues.",
                description = "The Iraq war doesn't have many parallels to Russia's invasion of Ukraine, other than perhaps global unpopularity. But there seems to be at least one parallel — how stocks have behaved.",
                author = "Steve Goldstein",
                date = "2022-04-07T10:57:00Z"
            ),
            News(
                id = 4,
                imageUrl = "https://images.barrons.com/im-511150/social",
                title = "Ford Stock Catches a Downgrade. The Problems Are Wide in the Auto Industry.",
                description = "Barclays analyst Brian Johnson downgrades shares of Ford to Hold from Buy. Inflation is a problem for the analyst.",
                author = "Al Root",
                date = "2022-04-07T10:54:21Z"
            ),
            News(
                id = 5,
                imageUrl = "https://g.foolcdn.com/editorial/images/672916/0x0-models_06.jpg",
                title = "How Tesla's Engineering-First Approach Beats the Competition",
                description = "Tesla's cars have to sell themselves when no money is spent on advertising.",
                author = "Keithen Drury",
                date = "2022-04-07T10:45:00Z"
            ),
            News(
                id = 6,
                imageUrl = "https://media.autoexpress.co.uk/image/private/s--X-WVjvBW--/f_auto,t_content-image-full-desktop@1/v1649328252/autoexpress/2022/04/Opinion - Nissan Leaf.jpg",
                title = "‘Informed consumers are vital to a mature electric car market’",
                description = "Andy Palmer thinks motorists need to learn more about electric cars with the 2030 petrol and diesel new car ban looming on the horizon",
                author = "Andy Palmer",
                date = "2022-04-07T10:39:11Z"
            ),
            News(
                id = 7,
                imageUrl = "https://i.insider.com/624deade1096d50018d1cffa?width=1200&format=jpeg",
                title = "10 things before the opening bell",
                description = "The Fed must balance between the markets and the economy, and Deutsche Bank's recession forecast for the US.",
                author = "Phil Rosen",
                date = "2022-04-07T10:35:54Z"
            ),
            News(
                id = 8,
                imageUrl = "https://i0.wp.com/electrek.co/wp-content/uploads/sites/3/2021/05/volcon-grunt-header2.jpg?resize=1200%2C628&quality=82&strip=all&ssl=1",
                title = "Watch as several Volcon Grunt electric motorcycles go for a swim riding right through a river",
                description = "Electric motorcycles have a wide range of advantages over their gas-powered counterparts. While most electric converts tout their low operation cost, lack of maintenance, and smoother power delivery, there’s one other big advantage that often goes unnoticed",
                author = "Micah Toll",
                date = "2022-04-07T10:35:34Z"
            ),
            News(
                id = 9,
                imageUrl = "https://static.bangkokpost.com/media/content/20220407/c1_2291790_700.jpg",
                title = "Vietnamese automaker VinFast files for US IPO to fund expansion",
                description = "HAIPHONG: Vietnamese automaker VinFast said on Thursday its Singapore-based holding company had filed for an initial public offering (IPO) of the group with US securities regulators, as it plans US\$4 billion spending on its first US factory complex.",
                author = "Reuters",
                date = "2022-04-07T10:35:00Z"
            ),
            News(
                id = 10,
                imageUrl = "https://assets.bwbx.io/images/users/iqjWHBFdfxIU/ibqLFk4YhN2w/v1/1200x833.jpg",
                title = "Tesla's Long and Winding Road to Get Europe's Backing for FSD",
                description = "Welcome to the Hyperdrive daily briefing, decoding the revolution reshaping the auto world, from EVs to self-driving cars and beyond. You can read today’s newsletter on the web here.",
                author = "Stefan Nicola",
                date = "2022-04-07T10:30:06Z"
            )
        )
    }
}