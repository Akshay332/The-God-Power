package com.goddess.base.repository.models

import com.codingwithmitch.kotlinrecyclerviewexample.models.BlogPost


class DataSource {
    companion object {
        fun createDataset(): ArrayList<BlogPost> {
            val list = ArrayList<BlogPost>()
            // added data in the list
            list.add(
                    BlogPost(
                            "Jack", "@jkrocks",
                            "Paris , France", "https://www.gladeculturalcenter.com/images/teachers/original/Alex_Profile.jpg"
                    )
            )
            list.add(
                    BlogPost(
                            "Samantha", "@samantha",
                            "Paris , France", "https://image.businessinsider.com/5db20c93dee01920987750b2?width=1100&format=jpeg&auto=webp"
                    )
            )
            list.add(
                    BlogPost(
                            "Jack", "@jkrocks",
                            "Paris , France", "https://image.businessinsider.com/5db20c93dee01920987750b2?width=1100&format=jpeg&auto=webp"
                    )
            )
            list.add(
                    BlogPost(
                            "Samantha", "@samantha",
                            "Paris , France", "https://www.gladeculturalcenter.com/images/teachers/original/Alex_Profile.jpg"
                    )
            )
            list.add(
                    BlogPost(
                            "Jack", "@jkrocks",
                            "Paris , France", "https://image.businessinsider.com/5db20c93dee01920987750b2?width=1100&format=jpeg&auto=webp"
                    )
            )
            list.add(
                    BlogPost(
                            "Samantha", "@samantha",
                            "Paris , France", "https://image.businessinsider.com/5db20c93dee01920987750b2?width=1100&format=jpeg&auto=webp"
                    )
            )



            return list
        }
    }
}