package com.rizkykurniawan.jetpackpro.submission.utils

import com.rizkykurniawan.jetpackpro.submission.data.source.local.entity.MovieEntity
import com.rizkykurniawan.jetpackpro.submission.data.source.local.entity.TVShowEntity
import com.rizkykurniawan.jetpackpro.submission.data.source.remote.response.MovieResponse
import com.rizkykurniawan.jetpackpro.submission.data.source.remote.response.TVShowResponse

object DummyData {
    fun generateDummyMovies(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
                "movie1",
                "A Star Is Born",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "75%",
                "10/05/2018",
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/poster_a_star_is_born.jpg"
        )
        )
        movies.add(
            MovieEntity(
                "movie2",
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "73%",
                "02/14/2019",
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/drawable.poster_alita.jpg"
        )
        )
        movies.add(
            MovieEntity(
            "movie3",
            "Aquaman",
            "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
            "69%",
            "12/21/2018",
            "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/drawable.poster_aquaman.jpg"
        )
        )
        movies.add(
            MovieEntity(
                "movie4",
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "80%",
                "11/02/2018",
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/poster_bohemian.jpg"
        )
        )
        movies.add(
            MovieEntity(
                "movie5",
                "Cold Pursuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "57%",
                "02/08/2019",
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/poster_cold_persuit.jpg"
        )
        )
        movies.add(
            MovieEntity(
                "movie6",
                "Creed II",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "69%",
                "11/21/2018",
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/poster_creed.jpg"
        )
        )
        movies.add(
            MovieEntity(
                "movie7",
                "Fantastic Beasts: The Crimes of Grindelwald",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "69%",
                "11/16/2018",
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/poster_crimes.jpg"
        )
        )
        movies.add(
            MovieEntity(
                "movie8",
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "67%",
                "01/18/2019",
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/poster_glass.jpg"
        )
        )
        movies.add(
            MovieEntity(
                "movie9",
                "How to Train Your Dragon: The Hidden World",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "78%",
                "01/09/2019",
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/poster_how_to_train.jpg"
        )
        )
        movies.add(
            MovieEntity(
                "movie10",
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "83%",
                "04/27/2018",
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/poster_infinity_war.jpg"
        )
        )
        return movies
    }

    fun generateDummyTVShows(): List<TVShowEntity> {
        val tvShows = ArrayList<TVShowEntity>()

        tvShows.add(
            TVShowEntity(
                "tv1",
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "66%",
                8,
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/poster_arrow.jpg"
        )
        )
        tvShows.add(
            TVShowEntity(
                "tv2",
                "Doom Patrol",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "76%",
                2,
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/poster_doom_patrol.jpg"
        )
        )
        tvShows.add(
            TVShowEntity(
                "tv3",
                "Dragon Ball",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "81%",
                1,
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/poster_dragon_ball.jpg"
        )
        )
        tvShows.add(
            TVShowEntity(
                "tv4",
                "Fairy Tail",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "78%",
                8,
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/poster_fairytail.jpg"
        )
        )
        tvShows.add(
            TVShowEntity(
                "tv5",
                "Family Guy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "70%",
                19,
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/poster_family_guy.jpg"
        )
        )
        tvShows.add(
            TVShowEntity(
                "tv6",
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "77%",
                7,
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/poster_flash.jpg"
        )
        )
        tvShows.add(
            TVShowEntity(
                "tv7",
                "NCIS",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                "74%",
                18,
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/poster_ncis.jpg"
        )
        )
        tvShows.add(
            TVShowEntity(
                "tv8",
                "Gotham",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "75%",
                5,
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/poster_gotham.jpg"
        )
        )
        tvShows.add(
            TVShowEntity(
                "tv9",
                "Grey's Anatomy",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "82%",
                17,
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/poster_grey_anatomy.jpg"
        )
        )
        tvShows.add(
            TVShowEntity(
                "tv10",
                "Hanna",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "75%",
                2,
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/poster_hanna.jpg"
        )
        )
        return tvShows
    }

    fun generateRemoteDummyMovies(): List<MovieResponse> {
        val movies = ArrayList<MovieResponse>()
        movies.add(
            MovieResponse(
                "movie1",
                "A Star Is Born",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "75%",
                "10/05/2018",
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/poster_a_star_is_born.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "movie2",
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "73%",
                "02/14/2019",
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/drawable.poster_alita.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "movie3",
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "69%",
                "12/21/2018",
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/drawable.poster_aquaman.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "movie4",
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "80%",
                "11/02/2018",
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/poster_bohemian.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "movie5",
                "Cold Pursuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "57%",
                "02/08/2019",
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/poster_cold_persuit.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "movie6",
                "Creed II",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "69%",
                "11/21/2018",
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/poster_creed.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "movie7",
                "Fantastic Beasts: The Crimes of Grindelwald",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "69%",
                "11/16/2018",
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/poster_crimes.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "movie8",
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "67%",
                "01/18/2019",
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/poster_glass.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "movie9",
                "How to Train Your Dragon: The Hidden World",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "78%",
                "01/09/2019",
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/poster_how_to_train.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "movie10",
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "83%",
                "04/27/2018",
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/poster_infinity_war.jpg"
            )
        )
        return movies
    }

    fun generateRemoteDummyTVShows(): List<TVShowResponse> {
        val tvShows = ArrayList<TVShowResponse>()

        tvShows.add(
            TVShowResponse(
                "tv1",
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "66%",
                8,
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/poster_arrow.jpg"
            )
        )
        tvShows.add(
            TVShowResponse(
                "tv2",
                "Doom Patrol",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "76%",
                2,
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/poster_doom_patrol.jpg"
            )
        )
        tvShows.add(
            TVShowResponse(
                "tv3",
                "Dragon Ball",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "81%",
                1,
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/poster_dragon_ball.jpg"
            )
        )
        tvShows.add(
            TVShowResponse(
                "tv4",
                "Fairy Tail",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "78%",
                8,
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/poster_fairytail.jpg"
            )
        )
        tvShows.add(
            TVShowResponse(
                "tv5",
                "Family Guy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "70%",
                19,
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/poster_family_guy.jpg"
            )
        )
        tvShows.add(
            TVShowResponse(
                "tv6",
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "77%",
                7,
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/poster_flash.jpg"
            )
        )
        tvShows.add(
            TVShowResponse(
                "tv7",
                "NCIS",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                "74%",
                18,
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/poster_ncis.jpg"
            )
        )
        tvShows.add(
            TVShowResponse(
                "tv8",
                "Gotham",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "75%",
                5,
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/poster_gotham.jpg"
            )
        )
        tvShows.add(
            TVShowResponse(
                "tv9",
                "Grey's Anatomy",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "82%",
                17,
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/poster_grey_anatomy.jpg"
            )
        )
        tvShows.add(
            TVShowResponse(
                "tv10",
                "Hanna",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "75%",
                2,
                "https://kykurniawan.github.io/files/AndroidJetpackPro_submission_assets/poster_hanna.jpg"
            )
        )
        return tvShows
    }
}