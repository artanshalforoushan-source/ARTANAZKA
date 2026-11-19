package com.example.data

object LevelDataProvider {

    val chapters = listOf(
        Chapter(
            id = 1,
            title = "باغ گلستان",
            subtitle = "شروع ماجراجویی با کلمات شیرین",
            startLevel = 1,
            endLevel = 20,
            colorHex = 0xFF2E7D32,
            iconEmoji = "🌸"
        ),
        Chapter(
            id = 2,
            title = "بازارچه کهن",
            subtitle = "جستجوی واژه‌ها در راسته بازار",
            startLevel = 21,
            endLevel = 45,
            colorHex = 0xFFD97706,
            iconEmoji = "🏺"
        ),
        Chapter(
            id = 3,
            title = "کویر پرستاره",
            subtitle = "رمزگشایی از رازهای شبانه",
            startLevel = 46,
            endLevel = 75,
            colorHex = 0xFF0284C7,
            iconEmoji = "✨"
        ),
        Chapter(
            id = 4,
            title = "کاخ چهلستون",
            subtitle = "شکوه زبان و ادب پارسی",
            startLevel = 76,
            endLevel = 100,
            colorHex = 0xFF7C3AED,
            iconEmoji = "🏛️"
        ),
        Chapter(
            id = 5,
            title = "قله دماوند",
            subtitle = "چالش سخت برای استادان کلمه",
            startLevel = 101,
            endLevel = 125,
            colorHex = 0xFFDC2626,
            iconEmoji = "🏔️"
        ),
        Chapter(
            id = 6,
            title = "دریای کاسپین",
            subtitle = "اقیانوس بی‌پایان واژگان",
            startLevel = 126,
            endLevel = 150,
            colorHex = 0xFF0D9488,
            iconEmoji = "🌊"
        )
    )

    private val handcraftedLevels: List<Level> = listOf(
        // ==========================================
        // فصل ۱: باغ گلستان (مراحل ۱ تا ۲۰) - ۳ حرفی / ساده
        // ==========================================
        Level(
            id = 1, chapterId = 1, chapterTitle = "باغ گلستان",
            letters = listOf("ا", "ب"),
            targetWords = listOf(
                TargetWord("آب", "مایه حیات و زلال‌ترین مایع"),
                TargetWord("با", "حرف اضافه همراهی")
            ),
            bonusWords = emptyList(), difficulty = LevelDifficulty.EASY
        ),
        Level(
            id = 2, chapterId = 1, chapterTitle = "باغ گلستان",
            letters = listOf("د", "ا", "ب"),
            targetWords = listOf(
                TargetWord("باد", "جریان هوای متحرک"),
                TargetWord("ادب", "فرهنگ، نزاکت و اخلاق خوش")
            ),
            bonusWords = listOf("ابدا"), difficulty = LevelDifficulty.EASY
        ),
        Level(
            id = 3, chapterId = 1, chapterTitle = "باغ گلستان",
            letters = listOf("ر", "ب", "ا"),
            targetWords = listOf(
                TargetWord("ابر", "توده بخار آب در آسمان"),
                TargetWord("بار", "محموله یا مرتبه و نوبت")
            ),
            bonusWords = listOf("ربا"), difficulty = LevelDifficulty.EASY
        ),
        Level(
            id = 4, chapterId = 1, chapterTitle = "باغ گلستان",
            letters = listOf("م", "ا", "ه"),
            targetWords = listOf(
                TargetWord("ماه", "قمر زیبای زمین و سی روز"),
                TargetWord("هم", "نشان اشتراک و پیوند")
            ),
            bonusWords = listOf("مه"), difficulty = LevelDifficulty.EASY
        ),
        Level(
            id = 5, chapterId = 1, chapterTitle = "باغ گلستان",
            letters = listOf("ر", "ا", "ه"),
            targetWords = listOf(
                TargetWord("راه", "مسیر، جاده و طریقت"),
                TargetWord("هر", "تک‌تک و جمیع موارد")
            ),
            bonusWords = listOf("ره"), difficulty = LevelDifficulty.EASY
        ),
        Level(
            id = 6, chapterId = 1, chapterTitle = "باغ گلستان",
            letters = listOf("ش", "ا", "ه"),
            targetWords = listOf(
                TargetWord("شاه", "فرمانروا و پادشاه"),
                TargetWord("آش", "غذای سنتی و گرم ایرانی")
            ),
            bonusWords = listOf("شه"), difficulty = LevelDifficulty.EASY
        ),
        Level(
            id = 7, chapterId = 1, chapterTitle = "باغ گلستان",
            letters = listOf("ش", "ی", "ر"),
            targetWords = listOf(
                TargetWord("شیر", "سلطان جنگل و نوشیدنی مقوی"),
                TargetWord("ریش", "موهای صورت و بن و ریشه")
            ),
            bonusWords = listOf("شر"), difficulty = LevelDifficulty.EASY
        ),
        Level(
            id = 8, chapterId = 1, chapterTitle = "باغ گلستان",
            letters = listOf("م", "و", "ش"),
            targetWords = listOf(
                TargetWord("موش", "جانور جونده کوچک و زرنگ"),
                TargetWord("شو", "برو، عمل کردن یا نمایش")
            ),
            bonusWords = listOf("شم"), difficulty = LevelDifficulty.EASY
        ),
        Level(
            id = 9, chapterId = 1, chapterTitle = "باغ گلستان",
            letters = listOf("ن", "و", "ر"),
            targetWords = listOf(
                TargetWord("نور", "روشنایی و تابش درخشان"),
                TargetWord("رو", "چهره، سطح و حرکت")
            ),
            bonusWords = listOf("ون"), difficulty = LevelDifficulty.EASY
        ),
        Level(
            id = 10, chapterId = 1, chapterTitle = "باغ گلستان",
            letters = listOf("د", "س", "ت"),
            targetWords = listOf(
                TargetWord("دست", "عضو یاری‌رسان بدن"),
                TargetWord("ست", "مجموعه هماهنگ")
            ),
            bonusWords = emptyList(), difficulty = LevelDifficulty.EASY
        ),
        Level(
            id = 11, chapterId = 1, chapterTitle = "باغ گلستان",
            letters = listOf("س", "ا", "ر"),
            targetWords = listOf(
                TargetWord("سار", "پرنده‌ای خوش‌آواز"),
                TargetWord("راس", "سر، قله و زاویه")
            ),
            bonusWords = listOf("سرا"), difficulty = LevelDifficulty.EASY
        ),
        Level(
            id = 12, chapterId = 1, chapterTitle = "باغ گلستان",
            letters = listOf("ک", "ا", "ر"),
            targetWords = listOf(
                TargetWord("کار", "تلاش، شغل و کوشش"),
                TargetWord("راک", "تخته‌سنگ بزرگ و سبک موسیقی")
            ),
            bonusWords = listOf("کر"), difficulty = LevelDifficulty.EASY
        ),
        Level(
            id = 13, chapterId = 1, chapterTitle = "باغ گلستان",
            letters = listOf("م", "ی", "ز"),
            targetWords = listOf(
                TargetWord("میز", "وسیله پایه دار برای مطالعه و کار"),
                TargetWord("زم", "سرما و سردی سخت")
            ),
            bonusWords = emptyList(), difficulty = LevelDifficulty.EASY
        ),
        Level(
            id = 14, chapterId = 1, chapterTitle = "باغ گلستان",
            letters = listOf("پ", "ا", "ی"),
            targetWords = listOf(
                TargetWord("پای", "عضو ایستادن و راه رفتن"),
                TargetWord("پی", "پایه و اساس ساختمان")
            ),
            bonusWords = listOf("یا"), difficulty = LevelDifficulty.EASY
        ),
        Level(
            id = 15, chapterId = 1, chapterTitle = "باغ گلستان",
            letters = listOf("گ", "ل", "ا"),
            targetWords = listOf(
                TargetWord("گل", "شکوفه زیبا و معطر طبیعت"),
                TargetWord("لاگ", "ثبت وقایع و گزارش")
            ),
            bonusWords = listOf("الگ"), difficulty = LevelDifficulty.EASY
        ),
        Level(
            id = 16, chapterId = 1, chapterTitle = "باغ گلستان",
            letters = listOf("ت", "ا", "ر"),
            targetWords = listOf(
                TargetWord("تار", "ساز اصیل ایرانی و تاریکی"),
                TargetWord("ترا", "تو را و ضمیر خطابی"),
                TargetWord("ارت", "زمین و خاک در زبان باستان")
            ),
            bonusWords = listOf("رت"), difficulty = LevelDifficulty.EASY
        ),
        Level(
            id = 17, chapterId = 1, chapterTitle = "باغ گلستان",
            letters = listOf("د", "ل", "ی"),
            targetWords = listOf(
                TargetWord("دل", "کانون احساسات و قلب"),
                TargetWord("یل", "پهلوان و دلاور میدان")
            ),
            bonusWords = listOf("ید"), difficulty = LevelDifficulty.EASY
        ),
        Level(
            id = 18, chapterId = 1, chapterTitle = "باغ گلستان",
            letters = listOf("ش", "ا", "د"),
            targetWords = listOf(
                TargetWord("شاد", "خوشحال، خندان و پرنشاط"),
                TargetWord("داش", "کوره آجرپزی یا رفیق")
            ),
            bonusWords = listOf("اش"), difficulty = LevelDifficulty.EASY
        ),
        Level(
            id = 19, chapterId = 1, chapterTitle = "باغ گلستان",
            letters = listOf("خ", "و", "ش"),
            targetWords = listOf(
                TargetWord("خوش", "نیکو، پسندیده و دلپذیر"),
                TargetWord("شو", "حرکت کردن یا نمایش")
            ),
            bonusWords = listOf("وخ"), difficulty = LevelDifficulty.EASY
        ),
        Level(
            id = 20, chapterId = 1, chapterTitle = "باغ گلستان",
            letters = listOf("ز", "ر", "د"),
            targetWords = listOf(
                TargetWord("زرد", "رنگ طلایی و پاییزی آفتاب"),
                TargetWord("درز", "فاصله و شکاف نازک بین دو چیز")
            ),
            bonusWords = listOf("رز"), difficulty = LevelDifficulty.EASY
        ),

        // ==========================================
        // فصل ۲: بازارچه کهن (مراحل ۲۱ تا ۴۵) - ۴ حرفی / متوسط
        // ==========================================
        Level(
            id = 21, chapterId = 2, chapterTitle = "بازارچه کهن",
            letters = listOf("پ", "ا", "ر", "س"),
            targetWords = listOf(
                TargetWord("پارس", "سرزمین کهن و باستانی ایران"),
                TargetWord("پاس", "نگهبانی و احترام به دیگران"),
                TargetWord("سار", "پرنده خوش‌پروبال"),
                TargetWord("سرا", "خانه، منزل و عمارت")
            ),
            bonusWords = listOf("راس", "سپرا"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 22, chapterId = 2, chapterTitle = "بازارچه کهن",
            letters = listOf("گ", "ل", "ا", "ب"),
            targetWords = listOf(
                TargetWord("گلاب", "عصاره خوشبوی گل محمدی"),
                TargetWord("برگ", "اندام سبز و شاداب درختان"),
                TargetWord("بال", "اندام پرواز پرندگان"),
                TargetWord("گل", "شکوفه رنگارنگ طبیعت")
            ),
            bonusWords = listOf("گال", "لاب", "بلا"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 23, chapterId = 2, chapterTitle = "بازارچه کهن",
            letters = listOf("ب", "ه", "ا", "ر"),
            targetWords = listOf(
                TargetWord("بهار", "فصل شکوفایی و آغاز سال نو"),
                TargetWord("راهب", "عابد و پرهیزگار"),
                TargetWord("بره", "گوسفند کوچک و معصوم"),
                TargetWord("رها", "آزاد و رها شده از بند")
            ),
            bonusWords = listOf("بهر", "ابه", "اهب"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 24, chapterId = 2, chapterTitle = "بازارچه کهن",
            letters = listOf("د", "ر", "خ", "ت"),
            targetWords = listOf(
                TargetWord("درخت", "گیاه کهنسال با تنه چوبی"),
                TargetWord("دختر", "فرزند دختر و مایه مهر خانواده"),
                TargetWord("رخت", "لباس، پوشاک و اسباب سفر"),
                TargetWord("ترد", "شکننده، تازه و خوش‌خوراک")
            ),
            bonusWords = listOf("رد", "تخر"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 25, chapterId = 2, chapterTitle = "بازارچه کهن",
            letters = listOf("ش", "ا", "د", "ی"),
            targetWords = listOf(
                TargetWord("شادی", "نشاط، سرور و لبخند"),
                TargetWord("یاد", "خاطره ماندگار در اندیشه"),
                TargetWord("دایی", "برادر مهربان مادر"),
                TargetWord("شید", "نور و پرتو درخشان")
            ),
            bonusWords = listOf("دای", "ایش"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 26, chapterId = 2, chapterTitle = "بازارچه کهن",
            letters = listOf("ک", "ت", "ا", "ب"),
            targetWords = listOf(
                TargetWord("کتاب", "بوستان دانایی و یار مهربان"),
                TargetWord("تاب", "وسیله بازی و تحمل رنج"),
                TargetWord("باک", "مخزن سوخت اتومبیل"),
                TargetWord("بک", "عقب و پشتیبانی")
            ),
            bonusWords = listOf("تک", "بت"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 27, chapterId = 2, chapterTitle = "بازارچه کهن",
            letters = listOf("د", "ا", "ن", "ش"),
            targetWords = listOf(
                TargetWord("دانش", "علم، آگاهی و خردورزی"),
                TargetWord("شاد", "شادمان و پرانرژی"),
                TargetWord("ندا", "بانگ و ندای آسمانی"),
                TargetWord("شنا", "ورزش شناوری در آب")
            ),
            bonusWords = listOf("دنا", "نشان"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 28, chapterId = 2, chapterTitle = "بازارچه کهن",
            letters = listOf("خ", "ا", "ن", "ه"),
            targetWords = listOf(
                TargetWord("خانه", "آشیانه گرم و مامن آرامش"),
                TargetWord("خوان", "سفره پربرکت و پهن‌شده"),
                TargetWord("نهان", "مخفی، پوشیده و راز"),
                TargetWord("ناه", "مخفف ناهید و ماه")
            ),
            bonusWords = listOf("هن", "اخ"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 29, chapterId = 2, chapterTitle = "بازارچه کهن",
            letters = listOf("م", "ا", "د", "ر"),
            targetWords = listOf(
                TargetWord("مادر", "فرشته مهر و فداکاری"),
                TargetWord("آدم", "انسان نخستین و بشر"),
                TargetWord("دام", "تله و حیوان اهلی"),
                TargetWord("مرد", "انسان بالغ و جوانمرد")
            ),
            bonusWords = listOf("درم", "مار"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 30, chapterId = 2, chapterTitle = "بازارچه کهن",
            letters = listOf("پ", "د", "ر", "م"),
            targetWords = listOf(
                TargetWord("پدر", "تکیه‌گاه استوار خانواده"),
                TargetWord("پرد", "پرده و حجاب کهن"),
                TargetWord("مرد", "مرد شجاع و دلاور"),
                TargetWord("درم", "سکه نقره قدیمی")
            ),
            bonusWords = listOf("رد", "دم"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 31, chapterId = 2, chapterTitle = "بازارچه کهن",
            letters = listOf("ب", "ا", "ز", "ا", "ر"),
            targetWords = listOf(
                TargetWord("بازار", "راسته داد و ستد و کسب"),
                TargetWord("ابزار", "وسایل کار دست و صنعت"),
                TargetWord("بارز", "آشکار، هویدا و روشن"),
                TargetWord("زیبا", "خوش‌رو، قشنگ و آراسته")
            ),
            bonusWords = listOf("راز", "زرد", "زار"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 32, chapterId = 2, chapterTitle = "بازارچه کهن",
            letters = listOf("س", "ف", "ا", "ل"),
            targetWords = listOf(
                TargetWord("سفال", "هنر باستانی کوزه‌گری"),
                TargetWord("فال", "پیشگویی و بخت‌آزمایی"),
                TargetWord("سال", "دوازده ماه خورشیدی"),
                TargetWord("سلف", "پیشینیان و گذشتگان")
            ),
            bonusWords = listOf("فلس", "لاس"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 33, chapterId = 2, chapterTitle = "بازارچه کهن",
            letters = listOf("ف", "ر", "ش", "ی"),
            targetWords = listOf(
                TargetWord("فرش", "دستباف نفیس و تار و پود نگارین"),
                TargetWord("شرف", "بزرگواری و آبرومندی"),
                TargetWord("شیر", "سلطان دشت و جنگل"),
                TargetWord("ریش", "ریشه درخت و اصالت")
            ),
            bonusWords = listOf("شیف", "شریف"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 34, chapterId = 2, chapterTitle = "بازارچه کهن",
            letters = listOf("ق", "ل", "م", "ی"),
            targetWords = listOf(
                TargetWord("قلم", "ابزار نگارش اندیشه‌ها"),
                TargetWord("لقم", "لقمه کردن و برداشتن"),
                TargetWord("میل", "خواهش درون و میله فلزی"),
                TargetWord("قم", "شهر تاریخی و زیارتی")
            ),
            bonusWords = listOf("ملق", "قیل"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 35, chapterId = 2, chapterTitle = "بازارچه کهن",
            letters = listOf("س", "و", "ز", "ن"),
            targetWords = listOf(
                TargetWord("سوزن", "ابزار ظریف خیاطی"),
                TargetWord("وزن", "سنگینی و عیار کالا"),
                TargetWord("زوس", "نیرومند در اساطیر"),
                TargetWord("سود", "منفعت و بهره حلال")
            ),
            bonusWords = listOf("ونس", "زن"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 36, chapterId = 2, chapterTitle = "بازارچه کهن",
            letters = listOf("چ", "ر", "ا", "غ"),
            targetWords = listOf(
                TargetWord("چراغ", "روشنایی‌بخش شب تار"),
                TargetWord("قارچ", "گیاه خوراکی چتری‌شکل"),
                TargetWord("داغ", "بسیار گرم و سوزان"),
                TargetWord("غار", "شکاف عمیق کوهستان")
            ),
            bonusWords = listOf("راغ", "چرا"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 37, chapterId = 2, chapterTitle = "بازارچه کهن",
            letters = listOf("ت", "ر", "ا", "ز", "و"),
            targetWords = listOf(
                TargetWord("ترازو", "سنجشگر عدالت و وزن"),
                TargetWord("وزارت", "نهاد عالی کشورداری"),
                TargetWord("روزا", "روشن همچون روز"),
                TargetWord("زور", "توان و قدرت بازو")
            ),
            bonusWords = listOf("تراز", "زار", "روات"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 38, chapterId = 2, chapterTitle = "بازارچه کهن",
            letters = listOf("ک", "ا", "س", "ه"),
            targetWords = listOf(
                TargetWord("کاسه", "ظرف سفالی گود برای غذا"),
                TargetWord("ساک", "کیف جادار مسافرتی"),
                TargetWord("کاه", "ساقه خشک‌شده گندم"),
                TargetWord("سکه", "پول فلزی ارزشمند")
            ),
            bonusWords = listOf("کس", "هاک"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 39, chapterId = 2, chapterTitle = "بازارچه کهن",
            letters = listOf("س", "ک", "ه", "ا"),
            targetWords = listOf(
                TargetWord("سکه", "پول طلایی و نقره‌ای"),
                TargetWord("کاسه", "ظرف سنتی غذاخوری"),
                TargetWord("کاه", "علوفه خوش‌خوراک دام"),
                TargetWord("هاس", "سکوت و خاموشی")
            ),
            bonusWords = listOf("اکه", "کس"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 40, chapterId = 2, chapterTitle = "بازارچه کهن",
            letters = listOf("س", "ف", "ر", "ه"),
            targetWords = listOf(
                TargetWord("سفره", "پهن‌شده برای اطعام مهمان"),
                TargetWord("سرفه", "واکنش پاک‌سازی ریه"),
                TargetWord("سفر", "راهی شدن به دیار نو"),
                TargetWord("فهرس", "فهرست و نمایه کتاب")
            ),
            bonusWords = listOf("فرس", "رس"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 41, chapterId = 2, chapterTitle = "بازارچه کهن",
            letters = listOf("ن", "م", "ک", "د", "ا", "ن"),
            targetWords = listOf(
                TargetWord("نمکدان", "ظرف چاشنی طعام"),
                TargetWord("دکان", "مغازه سنتی بازار"),
                TargetWord("کمان", "ابزار پرتاب تیر آرش"),
                TargetWord("نمک", "چاشنی سفید و شور غذا")
            ),
            bonusWords = listOf("کند", "دام", "نام"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 42, chapterId = 2, chapterTitle = "بازارچه کهن",
            letters = listOf("ق", "ن", "د", "ی"),
            targetWords = listOf(
                TargetWord("قند", "شیرینی خوشمزه چای"),
                TargetWord("دین", "آیین و شریعت الهی"),
                TargetWord("قید", "شرط و پیمان بسته"),
                TargetWord("دق", "کوبیدن در یا غصه خوردن")
            ),
            bonusWords = listOf("ندی", "قد"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 43, chapterId = 2, chapterTitle = "بازارچه کهن",
            letters = listOf("چ", "ا", "ی", "ی"),
            targetWords = listOf(
                TargetWord("چای", "نوشیدنی گرم و اصیل عصرانه"),
                TargetWord("یاچ", "قایق تفریحی بادبانی"),
                TargetWord("آی", "ندای شگفتی و ماه در ترکی"),
                TargetWord("چی", "پرسش از ماهیت شیء")
            ),
            bonusWords = listOf("یا", "چیا"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 44, chapterId = 2, chapterTitle = "بازارچه کهن",
            letters = listOf("ط", "ل", "ا", "ی"),
            targetWords = listOf(
                TargetWord("طلا", "فلز گرانبها و درخشان"),
                TargetWord("طی", "پیمودن راه و پاک کردن"),
                TargetWord("لات", "بی‌پروا یا نام بت کهن"),
                TargetWord("طال", "بلند و کشیده")
            ),
            bonusWords = listOf("ای", "طا"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 45, chapterId = 2, chapterTitle = "بازارچه کهن",
            letters = listOf("م", "س", "ی", "ن"),
            targetWords = listOf(
                TargetWord("مسین", "ظرف ساخته‌شده از فلز مس"),
                TargetWord("سیم", "فلز نقره و رشته رسانا"),
                TargetWord("مس", "فلز سرخ‌رنگ چکش‌خوار"),
                TargetWord("مین", "تله انفجاری یا گوهر ناب")
            ),
            bonusWords = listOf("نسیم", "سین"), difficulty = LevelDifficulty.MEDIUM
        ),

        // ==========================================
        // فصل ۳: کویر پرستاره (مراحل ۴۶ تا ۷۵) - ۵ حرفی / چالش‌برانگیز
        // ==========================================
        Level(
            id = 46, chapterId = 3, chapterTitle = "کویر پرستاره",
            letters = listOf("س", "ت", "ا", "ر", "ه"),
            targetWords = listOf(
                TargetWord("ستاره", "اجرام تابان آسمان شب"),
                TargetWord("راست", "مستقیم و سخن حقیقت"),
                TargetWord("تار", "ساز سنتی و تاریکی شب"),
                TargetWord("سرا", "سرای امید و منزل"),
                TargetWord("ترس", "بیم و هراس از ناشناخته")
            ),
            bonusWords = listOf("ترا", "سره", "رها", "هراس"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 47, chapterId = 3, chapterTitle = "کویر پرستاره",
            letters = listOf("د", "ل", "ا", "و", "ر"),
            targetWords = listOf(
                TargetWord("دلاور", "شجاع، پهلوان و دلیر"),
                TargetWord("داور", "قاضی عادل میدان مسابقه"),
                TargetWord("دلار", "واحد پول بین‌المللی"),
                TargetWord("وارد", "داخل شونده و آگاه به کار"),
                TargetWord("رود", "جریان زلال آب کوهستان")
            ),
            bonusWords = listOf("دارو", "لرد", "لوا", "دور"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 48, chapterId = 3, chapterTitle = "کویر پرستاره",
            letters = listOf("آ", "س", "م", "ا", "ن"),
            targetWords = listOf(
                TargetWord("آسمان", "گنبد نیلگون بالای سر"),
                TargetWord("سامان", "نظم، آرامش و آبادانی"),
                TargetWord("نما", "جلوه بیرونی ساختمان"),
                TargetWord("نام", "شناسه نیک هر فرد"),
                TargetWord("ماس", "دست کشیدن و لمس")
            ),
            bonusWords = listOf("سان", "انس", "من"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 49, chapterId = 3, chapterTitle = "کویر پرستاره",
            letters = listOf("خ", "و", "ر", "ش", "ی", "د"),
            targetWords = listOf(
                TargetWord("خورشید", "چشمه تابان نور و گرما"),
                TargetWord("شوخی", "بذله‌گویی و خنده"),
                TargetWord("خورد", "میل کردن غذا و لقمه"),
                TargetWord("شیر", "سلطان بیشه و صحرا"),
                TargetWord("روش", "طریق، متد و سبک زندگی")
            ),
            bonusWords = listOf("خرد", "دوش", "دیو", "شور"), difficulty = LevelDifficulty.HARD
        ),
        Level(
            id = 50, chapterId = 3, chapterTitle = "کویر پرستاره",
            letters = listOf("م", "ه", "ت", "ا", "ب"),
            targetWords = listOf(
                TargetWord("مهتاب", "پرتو نقره‌فام ماه شب چهارده"),
                TargetWord("ماست", "فرآورده خوشمزه لبنی"),
                TargetWord("تاب", "شکیبایی و تاب خوردن"),
                TargetWord("مات", "شگفت‌زده و مغلوب شطرنج"),
                TargetWord("بام", "بالاترین سطح ساختمان")
            ),
            bonusWords = listOf("بته", "تبه", "مته"), difficulty = LevelDifficulty.HARD
        ),
        Level(
            id = 51, chapterId = 3, chapterTitle = "کویر پرستاره",
            letters = listOf("ش", "ن", "ز", "ا", "ر"),
            targetWords = listOf(
                TargetWord("شنزار", "دشت بیکران ریگ‌های کویر"),
                TargetWord("ساز", "نوای دلنشین موسیقی"),
                TargetWord("ارزن", "دانه غلات پرندگان"),
                TargetWord("زنش", "سرزنش و ملامت"),
                TargetWord("راز", "سر مگو و پوشیده")
            ),
            bonusWords = listOf("ران", "زر", "نار"), difficulty = LevelDifficulty.HARD
        ),
        Level(
            id = 52, chapterId = 3, chapterTitle = "کویر پرستاره",
            letters = listOf("ش", "ت", "ر", "ب", "ا", "ن"),
            targetWords = listOf(
                TargetWord("شتربان", "راهنمای کاروان در کویر"),
                TargetWord("شتاب", "عجله و سرعت حرکت"),
                TargetWord("باران", "رحمت آسمانی"),
                TargetWord("انبار", "محل نگهداری غلات"),
                TargetWord("برنا", "جوان شاداب و رشید")
            ),
            bonusWords = listOf("شتر", "تاب", "ترش"), difficulty = LevelDifficulty.HARD
        ),
        Level(
            id = 53, chapterId = 3, chapterTitle = "کویر پرستاره",
            letters = listOf("ک", "ا", "ر", "و", "ا", "ن"),
            targetWords = listOf(
                TargetWord("کاروان", "گروه مسافران همسفر در راه"),
                TargetWord("روان", "روحی، جاری و سلیس"),
                TargetWord("ناوک", "تیر کوچک و چابک"),
                TargetWord("وان", "ظرف شستشو و شهر کهن"),
                TargetWord("انار", "میوه بهشتی یاقوت‌نشان")
            ),
            bonusWords = listOf("نار", "کاور", "کور"), difficulty = LevelDifficulty.HARD
        ),
        Level(
            id = 54, chapterId = 3, chapterTitle = "کویر پرستاره",
            letters = listOf("س", "ر", "ا", "ب", "ی"),
            targetWords = listOf(
                TargetWord("سراب", "فریب بصری آب در تشنگی کویر"),
                TargetWord("سرباز", "نگهبان میهن و فداکار"),
                TargetWord("بسیار", "فراوان و بی‌شمار"),
                TargetWord("سیر", "گیاه دارویی پرخاصیت یا سیراب"),
                TargetWord("یاس", "گل سپید خوش‌رایحه")
            ),
            bonusWords = listOf("سیب", "رای", "ابر"), difficulty = LevelDifficulty.HARD
        ),
        Level(
            id = 55, chapterId = 3, chapterTitle = "کویر پرستاره",
            letters = listOf("س", "ک", "و", "ت"),
            targetWords = listOf(
                TargetWord("سکوت", "خاموشی آرامش‌بخش کویر"),
                TargetWord("کوت", "انباشتن و پشته کردن"),
                TargetWord("سوت", "صدای بلند داور"),
                TargetWord("توس", "زادگاه حکیم طوس")
            ),
            bonusWords = listOf("کت", "سو"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 56, chapterId = 3, chapterTitle = "کویر پرستاره",
            letters = listOf("غ", "ر", "و", "ب"),
            targetWords = listOf(
                TargetWord("غروب", "پایان روز و سرخی شفق"),
                TargetWord("غور", "ژرف‌اندیشی و تامل"),
                TargetWord("بور", "موی خرمایی و سرشکسته"),
                TargetWord("روغ", "آواز دادن یا روغن")
            ),
            bonusWords = listOf("رو", "بو"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 57, chapterId = 3, chapterTitle = "کویر پرستاره",
            letters = listOf("ش", "ب", "ن", "م"),
            targetWords = listOf(
                TargetWord("شبنم", "قطره ژاله بر گلبرگ صبحگاهی"),
                TargetWord("شب", "هنگامه آرامش و ستاره"),
                TargetWord("منش", "خلق و خوی والای آدمی"),
                TargetWord("بشم", "بوییدن یا بشارت")
            ),
            bonusWords = listOf("شن", "نم"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 58, chapterId = 3, chapterTitle = "کویر پرستاره",
            letters = listOf("ش", "ه", "ا", "ب"),
            targetWords = listOf(
                TargetWord("شهاب", "تیر درخشان آسمان شب"),
                TargetWord("شاه", "پادشاه دادگر"),
                TargetWord("آش", "خوراک دلچسب سنتی"),
                TargetWord("بها", "ارزش و قیمت گرانبها")
            ),
            bonusWords = listOf("ابه", "شه"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 59, chapterId = 3, chapterTitle = "کویر پرستاره",
            letters = listOf("ک", "ه", "ک", "ش", "ا", "ن"),
            targetWords = listOf(
                TargetWord("کهکشان", "رود نقره‌ای ستارگان عالم"),
                TargetWord("کاهش", "کم شدن و تنزل"),
                TargetWord("نشان", "علامت و مدال افتخار"),
                TargetWord("شاهک", "شاه کوچک و ولیعهد"),
                TargetWord("شنا", "ورزش در آب‌های روان")
            ),
            bonusWords = listOf("کاک", "کنه", "شک"), difficulty = LevelDifficulty.HARD
        ),
        Level(
            id = 60, chapterId = 3, chapterTitle = "کویر پرستاره",
            letters = listOf("ن", "خ", "ل", "س", "ت", "ا", "ن"),
            targetWords = listOf(
                TargetWord("نخلستان", "واحه سرسبز و نخل‌های پرثمر"),
                TargetWord("داستان", "روایت و قصه کهن"),
                TargetWord("نخست", "اولین و آغازین"),
                TargetWord("سخت", "محکم و استوار"),
                TargetWord("تنها", "بی‌همتا و یگانه")
            ),
            bonusWords = listOf("نخل", "تاس", "سال"), difficulty = LevelDifficulty.HARD
        ),
        Level(
            id = 61, chapterId = 3, chapterTitle = "کویر پرستاره",
            letters = listOf("ق", "ن", "ا", "ت"),
            targetWords = listOf(
                TargetWord("قنات", "شاهکار مهندسی آب‌رسانی ایران کهن"),
                TargetWord("تقان", "استواری و دقت در کار"),
                TargetWord("نقاب", "پوشش چهره"),
                TargetWord("تان", "ضمیر شما در زبان ادب")
            ),
            bonusWords = listOf("تقا", "قتا"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 62, chapterId = 3, chapterTitle = "کویر پرستاره",
            letters = listOf("چ", "ش", "م", "ه"),
            targetWords = listOf(
                TargetWord("چشمه", "جوشش آب گوارا از دل سنگ"),
                TargetWord("چشم", "عضو بینایی و نگاه"),
                TargetWord("مشه", "موش کوچک در گویش کهن"),
                TargetWord("همه", "جمیع آفریدگان")
            ),
            bonusWords = listOf("چم", "مه"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 63, chapterId = 3, chapterTitle = "کویر پرستاره",
            letters = listOf("آ", "ت", "ش"),
            targetWords = listOf(
                TargetWord("آتش", "شعله فروزان و گرما"),
                TargetWord("شتا", "فصل زمستان و سرما"),
                TargetWord("تاش", "همتا و نظیر")
            ),
            bonusWords = listOf("تش"), difficulty = LevelDifficulty.EASY
        ),
        Level(
            id = 64, chapterId = 3, chapterTitle = "کویر پرستاره",
            letters = listOf("س", "پ", "ی", "د", "ه"),
            targetWords = listOf(
                TargetWord("سپیده", "دمیدن روشنایی سحر"),
                TargetWord("پایه", "اساس و ستون عمارت"),
                TargetWord("سایه", "پناهگاه خنک از آفتاب"),
                TargetWord("پسته", "آجیل خندان و مقوی"),
                TargetWord("دسته", "گروه هماهنگ یا دسته گل")
            ),
            bonusWords = listOf("پیدا", "سید", "دیه"), difficulty = LevelDifficulty.HARD
        ),
        Level(
            id = 65, chapterId = 3, chapterTitle = "کویر پرستاره",
            letters = listOf("ز", "ن", "د", "گ", "ی"),
            targetWords = listOf(
                TargetWord("زندگی", "حیات، پویایی و موهبت الهی"),
                TargetWord("گزین", "انتخاب‌شده و برگزیده"),
                TargetWord("دین", "باور و شریعت اخلاقی"),
                TargetWord("دیگ", "ظرف پخت طعام گرم"),
                TargetWord("زنگ", "آوای ناقوس و هشدار")
            ),
            bonusWords = listOf("گند", "زین", "گنبد"), difficulty = LevelDifficulty.HARD
        ),
        Level(
            id = 66, chapterId = 3, chapterTitle = "کویر پرستاره",
            letters = listOf("ر", "و", "ش", "ن", "ا"),
            targetWords = listOf(
                TargetWord("روشنا", "فروزان و تابنده"),
                TargetWord("روشن", "آفتابی و تابناک"),
                TargetWord("شناور", "روی آب ایستاده"),
                TargetWord("روان", "سلیس و بدون توقف"),
                TargetWord("نور", "پرتو رخشان خورشید")
            ),
            bonusWords = listOf("وان", "شور", "شن"), difficulty = LevelDifficulty.HARD
        ),
        Level(
            id = 67, chapterId = 3, chapterTitle = "کویر پرستاره",
            letters = listOf("آ", "ر", "ا", "م", "ش"),
            targetWords = listOf(
                TargetWord("آرامش", "سکون، طمأنینه و آسودگی"),
                TargetWord("آرام", "صبور و بی‌آشوب"),
                TargetWord("شام", "وعده غذای شبانگاهی"),
                TargetWord("آمار", "ارقام و سنجش آماری"),
                TargetWord("شرم", "حیا و پاکدامنی")
            ),
            bonusWords = listOf("مار", "آش", "ماش"), difficulty = LevelDifficulty.HARD
        ),
        Level(
            id = 68, chapterId = 3, chapterTitle = "کویر پرستاره",
            letters = listOf("ک", "و", "ی", "ر"),
            targetWords = listOf(
                TargetWord("کویر", "پهنه شنی و پر از سکوت"),
                TargetWord("رویک", "روش کوچک یا نگاه"),
                TargetWord("کور", "نابینا یا بی‌پایان"),
                TargetWord("ویر", "هوش و حافظه در پارسی")
            ),
            bonusWords = listOf("رو", "یو"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 69, chapterId = 3, chapterTitle = "کویر پرستاره",
            letters = listOf("س", "ف", "ر", "ن", "ا", "م", "ه"),
            targetWords = listOf(
                TargetWord("سفرنامه", "نگارش وقایع و دیده‌ها در سیر و سیاحت"),
                TargetWord("فرمان", "دستور حاکم و پیشوا"),
                TargetWord("سامان", "انضباط و رونق"),
                TargetWord("فانوس", "چراغ دستی روشن"),
                TargetWord("افسانه", "قصه پندآموز کهن")
            ),
            bonusWords = listOf("سفر", "نامه", "نام"), difficulty = LevelDifficulty.EXPERT
        ),
        Level(
            id = 70, chapterId = 3, chapterTitle = "کویر پرستاره",
            letters = listOf("ب", "ا", "د", "گ", "ی", "ر"),
            targetWords = listOf(
                TargetWord("بادگیر", "کولر طبیعی و کهن معماری یزد"),
                TargetWord("بیدار", "هوشیار و سحرخیز"),
                TargetWord("گرداب", "چرخش تند آب در رود"),
                TargetWord("دبیر", "معلم و نگارنده دانا"),
                TargetWord("گاری", "ارابه سنتی حمل بار")
            ),
            bonusWords = listOf("باد", "برگ", "دیبا"), difficulty = LevelDifficulty.EXPERT
        ),
        Level(
            id = 71, chapterId = 3, chapterTitle = "کویر پرستاره",
            letters = listOf("خ", "ا", "ک", "س", "ت", "ر"),
            targetWords = listOf(
                TargetWord("خاکستر", "برجای‌مانده از هیزم آتش"),
                TargetWord("تارک", "بالای سر و اوج قله"),
                TargetWord("راست", "صادق و بدون انحراف"),
                TargetWord("خسارت", "زیان و آسیب مالی"),
                TargetWord("تراش", "شکل‌دهی با ابزار")
            ),
            bonusWords = listOf("خاک", "ترس", "رخت"), difficulty = LevelDifficulty.EXPERT
        ),
        Level(
            id = 72, chapterId = 3, chapterTitle = "کویر پرستاره",
            letters = listOf("ب", "ا", "ر", "ا", "ن", "ی"),
            targetWords = listOf(
                TargetWord("بارانی", "لباس ضد آب یا هوای ابری"),
                TargetWord("انبار", "محل ذخیره گندم"),
                TargetWord("ایران", "سرزمین مادری و جاودان"),
                TargetWord("یاران", "دوستان صمیمی و یکدل"),
                TargetWord("برنا", "جوان دلاور و رشید")
            ),
            bonusWords = listOf("بار", "ابر", "یاور"), difficulty = LevelDifficulty.HARD
        ),
        Level(
            id = 73, chapterId = 3, chapterTitle = "کویر پرستاره",
            letters = listOf("س", "و", "ز", "ا", "ن"),
            targetWords = listOf(
                TargetWord("سوزان", "بسیار داغ و آتشین"),
                TargetWord("زانو", "مفصل پای انسان"),
                TargetWord("ساز", "دستگاه موسیقی کهن"),
                TargetWord("وزن", "سنگینی و عیار کالا"),
                TargetWord("سود", "بهره و دستاورد")
            ),
            bonusWords = listOf("وان", "سازن", "زن"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 74, chapterId = 3, chapterTitle = "کویر پرستاره",
            letters = listOf("ت", "ا", "ر", "ی", "خ"),
            targetWords = listOf(
                TargetWord("تاریخ", "آینه عبرت پیشینیان"),
                TargetWord("تاخیر", "دیرکرد در انجام کار"),
                TargetWord("خیار", "میوه خنک و ترد تابستان"),
                TargetWord("تار", "ساز خوش‌طنین ایرانی"),
                TargetWord("تیر", "نخستین ماه تابستان و اسلحه آرش")
            ),
            bonusWords = listOf("ریخت", "تخت", "خیر"), difficulty = LevelDifficulty.HARD
        ),
        Level(
            id = 75, chapterId = 3, chapterTitle = "کویر پرستاره",
            letters = listOf("خ", "و", "ا", "ب"),
            targetWords = listOf(
                TargetWord("خواب", "استراحت شبانه و رویا"),
                TargetWord("باخ", "موسیقی‌دان بزرگ یا باغ"),
                TargetWord("بو", "رایحه و عطر گل‌ها"),
                TargetWord("آب", "مایه هستی و زندگی")
            ),
            bonusWords = listOf("خو", "وبا"), difficulty = LevelDifficulty.EASY
        ),

        // ==========================================
        // فصل ۴: کاخ چهلستون (مراحل ۷۶ تا ۱۰۰) - ۶ حرفی / سخت و اصیل
        // ==========================================
        Level(
            id = 76, chapterId = 4, chapterTitle = "کاخ چهلستون",
            letters = listOf("ف", "ر", "ه", "ن", "گ"),
            targetWords = listOf(
                TargetWord("فرهنگ", "تمدن، ادب و هویت ملی"),
                TargetWord("هنر", "خلاقیت، زیبایی و ذوق"),
                TargetWord("رنگ", "جلوه بصری نورها"),
                TargetWord("رهن", "ضمانت و امانت مالی"),
                TargetWord("فر", "شکوه و جلال ایزدی")
            ),
            bonusWords = listOf("گرف", "نگه", "گره"), difficulty = LevelDifficulty.HARD
        ),
        Level(
            id = 77, chapterId = 4, chapterTitle = "کاخ چهلستون",
            letters = listOf("ف", "ر", "د", "و", "س", "ی"),
            targetWords = listOf(
                TargetWord("فردوسی", "احیاگر زبان پارسی و حماسه‌سرا"),
                TargetWord("سردار", "فرمانده شجاع سپاه"),
                TargetWord("دوست", "یار باوفا و همراه همیشگی"),
                TargetWord("ردیف", "نظم در اشعار سنتی"),
                TargetWord("سفید", "رنگ پاکی و برف کوهستان")
            ),
            bonusWords = listOf("سود", "درس", "دیو"), difficulty = LevelDifficulty.EXPERT
        ),
        Level(
            id = 78, chapterId = 4, chapterTitle = "کاخ چهلستون",
            letters = listOf("ش", "ا", "ه", "ن", "ا", "م", "ه"),
            targetWords = listOf(
                TargetWord("شاهنامه", "کتاب جاودانه حماسه‌های پارسی"),
                TargetWord("سامان", "آراستگی و نظام کشور"),
                TargetWord("شهنامه", "روایت دلاوران کهن"),
                TargetWord("ماهان", "شهر دیدنی کرمان یا مهتاب"),
                TargetWord("هامش", "حاشیه و یادداشت کتاب")
            ),
            bonusWords = listOf("شاه", "نامه", "آسمان"), difficulty = LevelDifficulty.EXPERT
        ),
        Level(
            id = 79, chapterId = 4, chapterTitle = "کاخ چهلستون",
            letters = listOf("ح", "ا", "ف", "ظ"),
            targetWords = listOf(
                TargetWord("حافظ", "لسان‌الغیب و غزلسرای نامدار"),
                TargetWord("حفاظ", "نگهبان و سپر محافظتی"),
                TargetWord("فاظ", "کلمه فصیح در ادب"),
                TargetWord("لحاف", "پوشش گرم خواب")
            ),
            bonusWords = listOf("ظفر", "حفظ"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 80, chapterId = 4, chapterTitle = "کاخ چهلستون",
            letters = listOf("س", "ع", "د", "ی"),
            targetWords = listOf(
                TargetWord("سعدی", "استاد سخن و صاحب گلستان"),
                TargetWord("عید", "جشن شادمانی و سرور"),
                TargetWord("دیس", "ظرف پذیرایی غذا"),
                TargetWord("سید", "بزرگوار و پیشوا")
            ),
            bonusWords = listOf("سعید", "عدس"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 81, chapterId = 4, chapterTitle = "کاخ چهلستون",
            letters = listOf("خ", "ی", "ا", "م"),
            targetWords = listOf(
                TargetWord("خیام", "ریاضی‌دان، ستاره‌شناس و رباعی‌سرا"),
                TargetWord("خیمه", "چادر برافراشته در دشت"),
                TargetWord("یاخ", "یخ در گویش باستان"),
                TargetWord("میخ", "اتصال‌دهنده چوب و دیوار")
            ),
            bonusWords = listOf("مایخ", "یام"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 82, chapterId = 4, chapterTitle = "کاخ چهلستون",
            letters = listOf("م", "و", "ل", "و", "ی"),
            targetWords = listOf(
                TargetWord("مولوی", "عارف بزرگ و سراینده مثنوی معنوی"),
                TargetWord("لیمو", "مرکبات ترش و معطر"),
                TargetWord("میل", "خواست قلبی و اشتیاق"),
                TargetWord("ولی", "سرپرست و همراه")
            ),
            bonusWords = listOf("ولیمه", "موی"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 83, chapterId = 4, chapterTitle = "کاخ چهلستون",
            letters = listOf("ع", "ط", "ا", "ر"),
            targetWords = listOf(
                TargetWord("عطار", "عارف نیشابور و داروفروش سنتی"),
                TargetWord("عطر", "بوی خوش و روح‌افزا"),
                TargetWord("طالع", "بخت و اقبال روشن"),
                TargetWord("رعطا", "بخشش و کرم")
            ),
            bonusWords = listOf("طاع", "عطا"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 84, chapterId = 4, chapterTitle = "کاخ چهلستون",
            letters = listOf("ن", "ظ", "ا", "م", "ی"),
            targetWords = listOf(
                TargetWord("نظامی", "خالق پنج گنج و هفت پیکر"),
                TargetWord("ناظم", "برقرارکننده انضباط"),
                TargetWord("منظوم", "سخن شعرگونه و آهنگین"),
                TargetWord("زمین", "سیاره خاکی ما"),
                TargetWord("نما", "جلوه ظاهری")
            ),
            bonusWords = listOf("ظن", "مین"), difficulty = LevelDifficulty.HARD
        ),
        Level(
            id = 85, chapterId = 4, chapterTitle = "کاخ چهلستون",
            letters = listOf("ش", "ه", "ر", "ی", "ا", "ر"),
            targetWords = listOf(
                TargetWord("شهریار", "شاعر پرآوازه حیدر بابا"),
                TargetWord("شیراز", "شهر شعر و گل و بلبل"),
                TargetWord("هشیار", "آگاه و بیدار دل"),
                TargetWord("شاهر", "آشکار و نامدار"),
                TargetWord("شیره", "عصاره میوه‌های شیرین")
            ),
            bonusWords = listOf("ریش", "شهر", "شاه"), difficulty = LevelDifficulty.EXPERT
        ),
        Level(
            id = 86, chapterId = 4, chapterTitle = "کاخ چهلستون",
            letters = listOf("گ", "ل", "س", "ت", "ا", "ن"),
            targetWords = listOf(
                TargetWord("گلستان", "شاهکار منثور سعدی شیرازی"),
                TargetWord("سالنت", "آرامش و وقار"),
                TargetWord("تنگسال", "قحطی و خشکسالی"),
                TargetWord("سنگلاخ", "زمین پر از سنگ"),
                TargetWord("گیلاس", "میوه قرمز و شیرین تابستان")
            ),
            bonusWords = listOf("گل", "سنگ", "تان"), difficulty = LevelDifficulty.EXPERT
        ),
        Level(
            id = 87, chapterId = 4, chapterTitle = "کاخ چهلستون",
            letters = listOf("ب", "و", "س", "ت", "ا", "ن"),
            targetWords = listOf(
                TargetWord("بوستان", "اثر منظوم و اخلاقی سعدی"),
                TargetWord("ستون", "پایه استوار سقف عمارت"),
                TargetWord("تابان", "درخشان و نورافشان"),
                TargetWord("توانا", "قدرتمند و دانا"),
                TargetWord("نبات", "شیرینی زعفرانی و گیاه")
            ),
            bonusWords = listOf("بست", "سوت", "ناب"), difficulty = LevelDifficulty.EXPERT
        ),
        Level(
            id = 88, chapterId = 4, chapterTitle = "کاخ چهلستون",
            letters = listOf("م", "ث", "ن", "و", "ی"),
            targetWords = listOf(
                TargetWord("مثنوی", "قالب شعری دارای ابیات هم‌قافیه"),
                TargetWord("ثمین", "گرانبها و باارزش"),
                TargetWord("متین", "باوقار، استوار و دانا"),
                TargetWord("نوین", "جدید و امروزی")
            ),
            bonusWords = listOf("میث", "وثن"), difficulty = LevelDifficulty.HARD
        ),
        Level(
            id = 89, chapterId = 4, chapterTitle = "کاخ چهلستون",
            letters = listOf("د", "ی", "و", "ا", "ن"),
            targetWords = listOf(
                TargetWord("دیوان", "مجموعه اشعار شاعر یا دفتر اداری"),
                TargetWord("نوید", "مژده و خبر مسرت‌بخش"),
                TargetWord("دین", "آیین و شریعت"),
                TargetWord("یوان", "ایوان بزرگ کاخ"),
                TargetWord("داو", "حق و نوبت در بازی")
            ),
            bonusWords = listOf("وید", "دای"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 90, chapterId = 4, chapterTitle = "کاخ چهلستون",
            letters = listOf("ق", "ص", "ی", "د", "ه"),
            targetWords = listOf(
                TargetWord("قصیده", "قالب بلند شعر پارسی"),
                TargetWord("صدیق", "دوست راستین و وفادار"),
                TargetWord("قاصد", "رساننده پیام و نامه"),
                TargetWord("صید", "شکار حلال در طبیعت"),
                TargetWord("قید", "بند و شرط پیمان")
            ),
            bonusWords = listOf("صدقه", "دیه"), difficulty = LevelDifficulty.HARD
        ),
        Level(
            id = 91, chapterId = 4, chapterTitle = "کاخ چهلستون",
            letters = listOf("غ", "ز", "ل"),
            targetWords = listOf(
                TargetWord("غزل", "شعر عاشقانه و عارفانه"),
                TargetWord("لغز", "چیستان و معما در ادب"),
                TargetWord("زل", "خیره شدن به نقطه‌ای")
            ),
            bonusWords = listOf("غل"), difficulty = LevelDifficulty.EASY
        ),
        Level(
            id = 92, chapterId = 4, chapterTitle = "کاخ چهلستون",
            letters = listOf("ر", "ب", "ا", "ع", "ی"),
            targetWords = listOf(
                TargetWord("رباعی", "شعر چهارمصراعی با وزن خاص"),
                TargetWord("عابر", "گذرنده از کوچه و خیابان"),
                TargetWord("عرب", "مردم بافرهنگ عرب‌زبان"),
                TargetWord("یار", "همدم و رفیق جان"),
                TargetWord("عیار", "سنجش خلوص طلا")
            ),
            bonusWords = listOf("ربع", "بار"), difficulty = LevelDifficulty.HARD
        ),
        Level(
            id = 93, chapterId = 4, chapterTitle = "کاخ چهلستون",
            letters = listOf("ب", "ی", "ت"),
            targetWords = listOf(
                TargetWord("بیت", "دو مصراع شعر یا خانه"),
                TargetWord("تب", "گرمی و حرارت بدن"),
                TargetWord("تیپ", "سبک پوشش و گروه ارتشی")
            ),
            bonusWords = listOf("بت"), difficulty = LevelDifficulty.EASY
        ),
        Level(
            id = 94, chapterId = 4, chapterTitle = "کاخ چهلستون",
            letters = listOf("م", "ص", "ر", "ا", "ع"),
            targetWords = listOf(
                TargetWord("مصراع", "نیم‌بیت شعر موزون"),
                TargetWord("معاصر", "هم‌دوره و معاصر در زمان"),
                TargetWord("صامت", "ساکت و حرف بی‌صدا"),
                TargetWord("عمار", "آبادکننده و پرهیزگار"),
                TargetWord("عصر", "زمانه و غروبگاه روز")
            ),
            bonusWords = listOf("مصر", "رسم", "مار"), difficulty = LevelDifficulty.HARD
        ),
        Level(
            id = 95, chapterId = 4, chapterTitle = "کاخ چهلستون",
            letters = listOf("ق", "ا", "ف", "ی", "ه"),
            targetWords = listOf(
                TargetWord("قافیه", "کلمات هم‌آهنگ پایان ابیات"),
                TargetWord("فقیه", "دانشمند علم احکام"),
                TargetWord("قیام", "برخاستن و جنبش"),
                TargetWord("قایق", "شناور سبک بر آب"),
                TargetWord("یافه", "سخن بیهوده")
            ),
            bonusWords = listOf("قهقهه", "قیف"), difficulty = LevelDifficulty.HARD
        ),
        Level(
            id = 96, chapterId = 4, chapterTitle = "کاخ چهلستون",
            letters = listOf("ت", "خ", "ل", "ص"),
            targetWords = listOf(
                TargetWord("تخلص", "نام شعری و ادبی شاعر"),
                TargetWord("خصلت", "ویژگی و خوی درونی"),
                TargetWord("صلت", "پاداش و جایزه به شاعران"),
                TargetWord("لخت", "برهنه یا پاره‌ای از زمان")
            ),
            bonusWords = listOf("اصل", "تخ"), difficulty = LevelDifficulty.HARD
        ),
        Level(
            id = 97, chapterId = 4, chapterTitle = "کاخ چهلستون",
            letters = listOf("م", "ع", "ن", "ی"),
            targetWords = listOf(
                TargetWord("معنی", "مفهوم و مغز کلام"),
                TargetWord("نعیم", "بهشت پرنعمت"),
                TargetWord("عین", "دقیقاً مانند یا چشمه"),
                TargetWord("مین", "تله یا گوهر ناب")
            ),
            bonusWords = listOf("نعم", "یم"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 98, chapterId = 4, chapterTitle = "کاخ چهلستون",
            letters = listOf("ل", "ف", "ظ"),
            targetWords = listOf(
                TargetWord("لفظ", "واژه و بیان زبانی"),
                TargetWord("ظل", "سایه و پناه در عربی"),
                TargetWord("فل", "شکستن یا فلز در زبان عامه")
            ),
            bonusWords = emptyList(), difficulty = LevelDifficulty.EASY
        ),
        Level(
            id = 99, chapterId = 4, chapterTitle = "کاخ چهلستون",
            letters = listOf("ا", "ی", "ه", "ا", "م"),
            targetWords = listOf(
                TargetWord("ایهام", "به کار بردن کلمه دو معنایی در شعر"),
                TargetWord("ماهی", "جانور زیبای آبزی"),
                TargetWord("ایما", "اشاره با گوشه چشم و رمز"),
                TargetWord("مایه", "خمیره و اصل و اساس"),
                TargetWord("هوا", "مایه تنفس زندگان")
            ),
            bonusWords = listOf("یاوه", "میها"), difficulty = LevelDifficulty.HARD
        ),
        Level(
            id = 100, chapterId = 4, chapterTitle = "کاخ چهلستون",
            letters = listOf("ت", "ش", "ب", "ی", "ه"),
            targetWords = listOf(
                TargetWord("تشبیه", "مانند کردن چیزی به چیز دیگر"),
                TargetWord("بهشت", "سرای جاودان نیکوکاران"),
                TargetWord("شبکه", "تار و پود ارتباطی"),
                TargetWord("تیشه", "ابزار کوه‌کنی فرهاد"),
                TargetWord("شیب", "سرازیری ملایم تپه")
            ),
            bonusWords = listOf("بشه", "تشت"), difficulty = LevelDifficulty.HARD
        ),

        // ==========================================
        // فصل ۵: قله دماوند (مراحل ۱۰۱ تا ۱۲۵) - ۶ و ۷ حرفی / چالش فوق‌العاده
        // ==========================================
        Level(
            id = 101, chapterId = 5, chapterTitle = "قله دماوند",
            letters = listOf("د", "م", "ا", "و", "ن", "د"),
            targetWords = listOf(
                TargetWord("دماوند", "بلندترین قله سرافراز ایران"),
                TargetWord("دادوند", "عادل و دادگستر"),
                TargetWord("دوان", "شتابان و در حال دویدن"),
                TargetWord("نماد", "نشانه و سمبل افتخار"),
                TargetWord("دامان", "پای کوه و آغوش مهر"),
                TargetWord("دوام", "پایداری و استقامت")
            ),
            bonusWords = listOf("داد", "دام", "دوم"), difficulty = LevelDifficulty.EXPERT
        ),
        Level(
            id = 102, chapterId = 5, chapterTitle = "قله دماوند",
            letters = listOf("پ", "ه", "ل", "و", "ا", "ن"),
            targetWords = listOf(
                TargetWord("پهلوان", "قهرمان زورخانه و میدان جوانمردی"),
                TargetWord("پنهان", "مخفی از دیدگان"),
                TargetWord("پلنگ", "یوز تیزپا و شجاع"),
                TargetWord("هاون", "ابزار کوبیدن زعفران"),
                TargetWord("نهال", "درختچه نوپا و تازه"),
                TargetWord("پلو", "برنج ایرانی دم‌کشیده")
            ),
            bonusWords = listOf("والا", "پناه", "هوا"), difficulty = LevelDifficulty.EXPERT
        ),
        Level(
            id = 103, chapterId = 5, chapterTitle = "قله دماوند",
            letters = listOf("س", "ی", "م", "ر", "غ"),
            targetWords = listOf(
                TargetWord("سیمرغ", "پرنده خردمند و نجات‌بخش شاهنامه"),
                TargetWord("مگس", "حشره موذی"),
                TargetWord("سیم", "رشته فلزی رسانا"),
                TargetWord("مرغ", "پرنده خانگی"),
                TargetWord("رسم", "سنت و آیین گذشتگان")
            ),
            bonusWords = listOf("میس", "غم"), difficulty = LevelDifficulty.HARD
        ),
        Level(
            id = 104, chapterId = 5, chapterTitle = "قله دماوند",
            letters = listOf("ر", "س", "ت", "م"),
            targetWords = listOf(
                TargetWord("رستم", "تهمتن و نامدارترین جهان‌پهلوان"),
                TargetWord("مستر", "استاد و پیشکسوت"),
                TargetWord("ترس", "بیم در دل راه دادن"),
                TargetWord("سرم", "مایع دارویی شفاخانه‌ها")
            ),
            bonusWords = listOf("متر", "مس"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 105, chapterId = 5, chapterTitle = "قله دماوند",
            letters = listOf("س", "ه", "ر", "ا", "ب"),
            targetWords = listOf(
                TargetWord("سهراب", "یل نامدار و فرزند پاک رستم"),
                TargetWord("بهار", "فصل گل و سنبل"),
                TargetWord("سراسر", "تمامی پهنه گیتی"),
                TargetWord("سرباز", "مدافع خاک پاک وطن"),
                TargetWord("راغب", "مشتاق و علاقمند"),
                TargetWord("بهرام", "سیاره مریخ و پادشاه دادگر")
            ),
            bonusWords = listOf("سره", "رها", "ابر"), difficulty = LevelDifficulty.EXPERT
        ),
        Level(
            id = 106, chapterId = 5, chapterTitle = "قله دماوند",
            letters = listOf("ز", "ا", "ل", "ر", "و"),
            targetWords = listOf(
                TargetWord("زال", "پدر رستم با موهای سپید"),
                TargetWord("راز", "امر نهان در سینه"),
                TargetWord("لرز", "تکان ناشی از سرما"),
                TargetWord("زور", "نیروی فیزیکی"),
                TargetWord("الرز", "ارتعاش و لرزه")
            ),
            bonusWords = listOf("زر", "لا"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 107, chapterId = 5, chapterTitle = "قله دماوند",
            letters = listOf("ت", "ه", "م", "ت", "ن"),
            targetWords = listOf(
                TargetWord("تهمتن", "لقب رستم دستان به معنای قوی‌پیکر"),
                TargetWord("تنها", "بی‌همتا در شجاعت"),
                TargetWord("مهم", "دارای ارزش فراوان"),
                TargetWord("همت", "عزم راسخ و اراده پولادین"),
                TargetWord("منت", "سپاس و نیکویی")
            ),
            bonusWords = listOf("تنم", "مهت"), difficulty = LevelDifficulty.HARD
        ),
        Level(
            id = 108, chapterId = 5, chapterTitle = "قله دماوند",
            letters = listOf("ر", "خ", "ش"),
            targetWords = listOf(
                TargetWord("رخش", "اسب وفادار، تنومند و تیزتک رستم"),
                TargetWord("شاخ", "اندام دفاعی آهو و گوزن"),
                TargetWord("چرخ", "ابزار چرخان خودرو"),
                TargetWord("خرش", "خراشیدن و ساییدن")
            ),
            bonusWords = listOf("رخ", "خش"), difficulty = LevelDifficulty.EASY
        ),
        Level(
            id = 109, chapterId = 5, chapterTitle = "قله دماوند",
            letters = listOf("گ", "ر", "ز"),
            targetWords = listOf(
                TargetWord("گرز", "سلاح سنگین پهلوانان با سر گاوسار"),
                TargetWord("رز", "گل سرخ و بوته انگور"),
                TargetWord("زر", "طلای ناب معدن")
            ),
            bonusWords = listOf("گز"), difficulty = LevelDifficulty.EASY
        ),
        Level(
            id = 110, chapterId = 5, chapterTitle = "قله دماوند",
            letters = listOf("ک", "م", "ا", "ن", "د", "ا", "ر"),
            targetWords = listOf(
                TargetWord("کماندار", "تیرانداز ماهر و پرچمدار سپاه"),
                TargetWord("دامان", "کوهپایه سرسبز"),
                TargetWord("کاردان", "باتجربه و متخصص"),
                TargetWord("دانامرد", "مرد اهل خرد"),
                TargetWord("انارک", "انار کوچک خودرو"),
                TargetWord("مراد", "آرزو و مقصود دل")
            ),
            bonusWords = listOf("کمان", "کار", "نام"), difficulty = LevelDifficulty.EXPERT
        ),
        Level(
            id = 111, chapterId = 5, chapterTitle = "قله دماوند",
            letters = listOf("آ", "ر", "ش"),
            targetWords = listOf(
                TargetWord("آرش", "کمانگیر نام‌آور مرزهای ایران"),
                TargetWord("شار", "شهر در پهلوی یا آبشار"),
                TargetWord("آرا", "زینت‌بخش و آراینده")
            ),
            bonusWords = listOf("رش"), difficulty = LevelDifficulty.EASY
        ),
        Level(
            id = 112, chapterId = 5, chapterTitle = "قله دماوند",
            letters = listOf("س", "ی", "ا", "و", "ش"),
            targetWords = listOf(
                TargetWord("سیاوش", "نماد پاکی، مظلومیت و راستی"),
                TargetWord("سویا", "دانه روغنی گیاهی"),
                TargetWord("شاسی", "اسکلت فلزی اتومبیل"),
                TargetWord("یاس", "گل سفید عطرآگین"),
                TargetWord("سوا", "جداگانه و منفک"),
                TargetWord("شوی", "شوهر در ادبیات کهن")
            ),
            bonusWords = listOf("وی", "آس"), difficulty = LevelDifficulty.HARD
        ),
        Level(
            id = 113, chapterId = 5, chapterTitle = "قله دماوند",
            letters = listOf("ک", "ا", "و", "ه"),
            targetWords = listOf(
                TargetWord("کاوه", "آهنگر شجاع دادخواه علیه ضحاک"),
                TargetWord("کوه", "برآمدگی سنگی سرافراز"),
                TargetWord("کاه", "ساقه خشک گندم"),
                TargetWord("هوا", "محیط تنفس انسان")
            ),
            bonusWords = listOf("کو", "هو"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 114, chapterId = 5, chapterTitle = "قله دماوند",
            letters = listOf("د", "ر", "ف", "ش"),
            targetWords = listOf(
                TargetWord("درفش", "پرچم مقدس کاویانی بر فراز آسمان"),
                TargetWord("فرش", "گستردنی نفیس"),
                TargetWord("فرد", "شخص یکتا و تنها"),
                TargetWord("شرف", "عزت و سربلندی انسان")
            ),
            bonusWords = listOf("شف", "دف"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 115, chapterId = 5, chapterTitle = "قله دماوند",
            letters = listOf("ف", "ر", "ی", "د", "و", "ن"),
            targetWords = listOf(
                TargetWord("فریدون", "پادشاه فرخنده و شکست‌دهنده ضحاک"),
                TargetWord("فردین", "جوانمرد و پهلوان خوش‌رو"),
                TargetWord("دیروز", "گذشته و روز پیشین"),
                TargetWord("فروردین", "آغازین ماه بهار خرم"),
                TargetWord("فنون", "مهارت‌ها و شگردهای فنی"),
                TargetWord("نوید", "مژده پیروزی و ظفر")
            ),
            bonusWords = listOf("دین", "فرد", "فرو"), difficulty = LevelDifficulty.EXPERT
        ),
        Level(
            id = 116, chapterId = 5, chapterTitle = "قله دماوند",
            letters = listOf("ب", "ی", "ژ", "ن"),
            targetWords = listOf(
                TargetWord("بیژن", "پهلوان دلاور و دلداده منیژه"),
                TargetWord("جین", "پارچه محکم و بادوام"),
                TargetWord("بین", "نگاه کن یا میان دو چیز"),
                TargetWord("نبش", "گوشه و زاویه خیابان")
            ),
            bonusWords = listOf("بن", "ژن"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 117, chapterId = 5, chapterTitle = "قله دماوند",
            letters = listOf("م", "ن", "ی", "ژ", "ه"),
            targetWords = listOf(
                TargetWord("منیژه", "شاهدخت وفادار و یار بیژن"),
                TargetWord("میهن", "زادگاه عزیز و خاک پاک"),
                TargetWord("نیمه", "نصف و بخش میانی"),
                TargetWord("نیزه", "سلاح تیز پرتابی پهلوانان"),
                TargetWord("ژاله", "قطره زلال شبنم صبحگاهی")
            ),
            bonusWords = listOf("من", "نه"), difficulty = LevelDifficulty.HARD
        ),
        Level(
            id = 118, chapterId = 5, chapterTitle = "قله دماوند",
            letters = listOf("گ", "ی", "و"),
            targetWords = listOf(
                TargetWord("گیو", "پهلوان شجاع و پدر بیژن"),
                TargetWord("گوی", "کره مدور بازی"),
                TargetWord("وی", "ضمیر سوم شخص مفرد")
            ),
            bonusWords = listOf("گو"), difficulty = LevelDifficulty.EASY
        ),
        Level(
            id = 119, chapterId = 5, chapterTitle = "قله دماوند",
            letters = listOf("گ", "و", "د", "ر", "ز"),
            targetWords = listOf(
                TargetWord("گودرز", "پیر دانا و فرمانده ارشد سپاه ایران"),
                TargetWord("گردو", "مغز آجیلی مقوی و سرشار از فسفر"),
                TargetWord("روزگار", "چرخش زمان و ایام"),
                TargetWord("درگاه", "ورودی کاخ و آستانه"),
                TargetWord("گوزن", "حیوان زیبای شاخ‌دار جنگل"),
                TargetWord("زرد", "رنگ برگ‌های پاییزی")
            ),
            bonusWords = listOf("گود", "زور", "درز"), difficulty = LevelDifficulty.EXPERT
        ),
        Level(
            id = 120, chapterId = 5, chapterTitle = "قله دماوند",
            letters = listOf("ت", "و", "س"),
            targetWords = listOf(
                TargetWord("توس", "سپهسالار نامی ایران و زادگاه فردوسی"),
                TargetWord("سوت", "صدای بلند زنگ"),
                TargetWord("سو", "سمت، جهت و نور چشم")
            ),
            bonusWords = listOf("تو"), difficulty = LevelDifficulty.EASY
        ),
        Level(
            id = 121, chapterId = 5, chapterTitle = "قله دماوند",
            letters = listOf("ف", "ر", "ا", "م", "ر", "ز"),
            targetWords = listOf(
                TargetWord("فرامرز", "فرزند دلاور و سلحشور رستم"),
                TargetWord("سرفراز", "سربلند، مغرور و پیروز"),
                TargetWord("مزارع", "کشتزارهای پهناور گندم"),
                TargetWord("فرار", "گریختن از مهلکه"),
                TargetWord("رمز", "کد مخفی و راز مگو"),
                TargetWord("آزار", "اذیت و رنج دادن")
            ),
            bonusWords = listOf("مرز", "فراز", "مار"), difficulty = LevelDifficulty.EXPERT
        ),
        Level(
            id = 122, chapterId = 5, chapterTitle = "قله دماوند",
            letters = listOf("ب", "ر", "ز", "و"),
            targetWords = listOf(
                TargetWord("برزو", "پهلوان رشید و نوه رستم"),
                TargetWord("زور", "توانمندی عضلات"),
                TargetWord("روز", "زمان تابش خورشید"),
                TargetWord("وزیر", "مشاور ارشد پادشاه")
            ),
            bonusWords = listOf("رز", "بو"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 123, chapterId = 5, chapterTitle = "قله دماوند",
            letters = listOf("ز", "و", "ا", "ر", "ه"),
            targetWords = listOf(
                TargetWord("زواره", "برادر وفادار رستم دستان"),
                TargetWord("آرزو", "امید قلبی و خواست درونی"),
                TargetWord("هزار", "عدد ده صد و بلبل خوشخوان"),
                TargetWord("روزه", "امساک عبادی و پرهیزکاری"),
                TargetWord("زهر", "ماده تلخ و کشنده مار")
            ),
            bonusWords = listOf("زهرا", "راه", "زور"), difficulty = LevelDifficulty.HARD
        ),
        Level(
            id = 124, chapterId = 5, chapterTitle = "قله دماوند",
            letters = listOf("ش", "غ", "ا", "د"),
            targetWords = listOf(
                TargetWord("شغاد", "برادر ناتنی رستم در شاهنامه"),
                TargetWord("شاد", "خوشحال و لبخندزنان"),
                TargetWord("داغ", "سوزان از تابش آفتاب"),
                TargetWord("غذا", "طعام مقوی جسم")
            ),
            bonusWords = listOf("اش", "قد"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 125, chapterId = 5, chapterTitle = "قله دماوند",
            letters = listOf("ا", "ف", "ر", "ا", "س", "ی", "ا", "ب"),
            targetWords = listOf(
                TargetWord("افراسیاب", "پادشاه توران در شاهنامه"),
                TargetWord("سرافراز", "سربلند و عزتمند"),
                TargetWord("آسیاب", "گردونه آرد کردن گندم با آب"),
                TargetWord("فارسی", "زبان شکرین مادری ما"),
                TargetWord("بسیار", "بی‌شمار و فراوان"),
                TargetWord("سفارت", "نمایندگی دیپلماتیک کشور")
            ),
            bonusWords = listOf("سفر", "آب", "پارس"), difficulty = LevelDifficulty.EXPERT
        ),

        // ==========================================
        // فصل ۶: دریای کاسپین (مراحل ۱۲۶ تا ۱۵۰+) - ۷ و ۸ حرفی / اقیانوس کلمات
        // ==========================================
        Level(
            id = 126, chapterId = 6, chapterTitle = "دریای کاسپین",
            letters = listOf("ک", "ا", "س", "پ", "ی", "ن"),
            targetWords = listOf(
                TargetWord("کاسپین", "بزرگترین دریاچه نیلگون جهان"),
                TargetWord("پیکان", "تیر تیز و اتومبیل خاطره‌انگیز"),
                TargetWord("سینک", "ظرفشویی آشپزخانه"),
                TargetWord("کاپشن", "لباس گرم زمستانه"),
                TargetWord("کاسب", "بازاری زحمتکش"),
                TargetWord("پاکس", "پاکی و آرامش")
            ),
            bonusWords = listOf("پاک", "ساک", "پای"), difficulty = LevelDifficulty.EXPERT
        ),
        Level(
            id = 127, chapterId = 6, chapterTitle = "دریای کاسپین",
            letters = listOf("م", "ا", "ز", "ن", "د", "ر", "ا", "ن"),
            targetWords = listOf(
                TargetWord("مازندران", "سرزمین جنگل‌های هیرکانی و دریا"),
                TargetWord("نامدار", "مشهور و بلندآوازه"),
                TargetWord("سازمان", "نهاد و اداره رسمی"),
                TargetWord("دربان", "نگهبان ورودی عمارت"),
                TargetWord("انارستان", "باغ درختان انار"),
                TargetWord("درمان", "بهبود بیماری و شفا")
            ),
            bonusWords = listOf("مادر", "نار", "آسمان"), difficulty = LevelDifficulty.EXPERT
        ),
        Level(
            id = 128, chapterId = 6, chapterTitle = "دریای کاسپین",
            letters = listOf("گ", "ی", "ل", "ا", "ن"),
            targetWords = listOf(
                TargetWord("گیلان", "استان باران و برنجزارها"),
                TargetWord("نگین", "گوهر درخشان روی انگشتر"),
                TargetWord("گلاب", "عطر سنتی ایرانی"),
                TargetWord("نهال", "گیاه جوان و سرسبز"),
                TargetWord("لنگان", "آهسته و با تکیه رفتن"),
                TargetWord("گونی", "کیسه بزرگ کنفی")
            ),
            bonusWords = listOf("گلی", "لگن", "لان"), difficulty = LevelDifficulty.HARD
        ),
        Level(
            id = 129, chapterId = 6, chapterTitle = "دریای کاسپین",
            letters = listOf("ج", "ن", "گ", "ل"),
            targetWords = listOf(
                TargetWord("جنگل", "انبوهی از درختان کهنسال و حیات وحش"),
                TargetWord("لنگ", "تکیه‌گاه یا لنگر کشتی"),
                TargetWord("گنج", "دفینه ارزشمند پنهان"),
                TargetWord("لجن", "گل و لای کف مرداب")
            ),
            bonusWords = listOf("جن", "گل"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 130, chapterId = 6, chapterTitle = "دریای کاسپین",
            letters = listOf("س", "ا", "ح", "ل"),
            targetWords = listOf(
                TargetWord("ساحل", "مرز ماسه‌ای خشکی و دریا"),
                TargetWord("سلاح", "ابزار دفاع از میهن"),
                TargetWord("حال", "اکنون و وضعیت روحی"),
                TargetWord("لسان", "زبان و گفتار")
            ),
            bonusWords = listOf("حل", "سل"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 131, chapterId = 6, chapterTitle = "دریای کاسپین",
            letters = listOf("م", "و", "ج"),
            targetWords = listOf(
                TargetWord("موج", "خیزاب پرشکوه آب دریا"),
                TargetWord("جام", "کاسه بلورین نوشیدنی"),
                TargetWord("جو", "آب و هوا یا غله دامی")
            ),
            bonusWords = listOf("مج"), difficulty = LevelDifficulty.EASY
        ),
        Level(
            id = 132, chapterId = 6, chapterTitle = "دریای کاسپین",
            letters = listOf("ق", "ا", "ی", "ق"),
            targetWords = listOf(
                TargetWord("قایق", "شناور چوبی بر بستر امواج"),
                TargetWord("قیام", "خیزش و برپا خاستن"),
                TargetWord("یاقه", "یقه لباس در ترکی"),
                TargetWord("قیف", "وسیله انتقال مایعات")
            ),
            bonusWords = listOf("آق", "یاق"), difficulty = LevelDifficulty.EASY
        ),
        Level(
            id = 133, chapterId = 6, chapterTitle = "دریای کاسپین",
            letters = listOf("ک", "ش", "ت", "ی"),
            targetWords = listOf(
                TargetWord("کشتی", "شناور بزرگ اقیانوس‌پیما و ورزش ملی"),
                TargetWord("تشک", "بستر نرم خواب و تشک مسابقه"),
                TargetWord("شیک", "شیک‌پوش و آراسته"),
                TargetWord("کشت", "زراعت و کشاورزی پربرکت")
            ),
            bonusWords = listOf("شک", "تک"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 134, chapterId = 6, chapterTitle = "دریای کاسپین",
            letters = listOf("م", "ا", "ه", "ی", "گ", "ی", "ر"),
            targetWords = listOf(
                TargetWord("ماهیگیر", "صیاد کهنه‌کار دریاها"),
                TargetWord("گرامی", "ارزشمند و محترم"),
                TargetWord("گمراه", "منحرف از راه صواب"),
                TargetWord("ماهی", "موجود زلال آب‌های روان"),
                TargetWord("گیاه", "روئیدنی سبز خاک"),
                TargetWord("همیار", "یاری‌رسان و همراه")
            ),
            bonusWords = listOf("ریگ", "گام", "یار"), difficulty = LevelDifficulty.EXPERT
        ),
        Level(
            id = 135, chapterId = 6, chapterTitle = "دریای کاسپین",
            letters = listOf("م", "ر", "د", "ا", "ب"),
            targetWords = listOf(
                TargetWord("مرداب", "آبگیر آرام با نیلوفرهای آبی"),
                TargetWord("مادر", "کانون مهر خانواده"),
                TargetWord("بادام", "خشکبار مغذی و خوشمزه"),
                TargetWord("داماد", "عروس و داماد خوشبخت"),
                TargetWord("بیدار", "هشیار در سحرگاه"),
                TargetWord("آباد", "سرسبز و پررونق")
            ),
            bonusWords = listOf("مرد", "دار", "ابر"), difficulty = LevelDifficulty.HARD
        ),
        Level(
            id = 136, chapterId = 6, chapterTitle = "دریای کاسپین",
            letters = listOf("ن", "ی", "ل", "و", "ف", "ر"),
            targetWords = listOf(
                TargetWord("نیلوفر", "گل زیبای برآمده از آب‌های زلال"),
                TargetWord("فوری", "سریع و بی‌درنگ"),
                TargetWord("نوری", "درخشان از جنس تابش"),
                TargetWord("روشن", "تابناک و پرفروغ"),
                TargetWord("لوزی", "شکل هندسی متقارن"),
                TargetWord("فنی", "حرفه‌ای و دارای تخصص")
            ),
            bonusWords = listOf("فیل", "نفل", "رول"), difficulty = LevelDifficulty.EXPERT
        ),
        Level(
            id = 137, chapterId = 6, chapterTitle = "دریای کاسپین",
            letters = listOf("ش", "ا", "ل", "ی", "ز", "ا", "ر"),
            targetWords = listOf(
                TargetWord("شالیزار", "مزرعه کشت برنج معطر طارم"),
                TargetWord("شیراز", "شهر بهارنارنج و شعر"),
                TargetWord("لیزر", "اشعه نوری پرتوان"),
                TargetWord("زیبا", "خوش‌طرح و دلنشین"),
                TargetWord("آسیاب", "گردونه آرد گندم"),
                TargetWord("شیرین", "مزه قند و عسل")
            ),
            bonusWords = listOf("شال", "راز", "ریال"), difficulty = LevelDifficulty.EXPERT
        ),
        Level(
            id = 138, chapterId = 6, chapterTitle = "دریای کاسپین",
            letters = listOf("ب", "ا", "ر", "ا", "ن"),
            targetWords = listOf(
                TargetWord("باران", "قطرات حیات‌بخش ابرهای شمال"),
                TargetWord("انبار", "محل ذخیره توشه"),
                TargetWord("برنا", "جوان شاداب و برومند"),
                TargetWord("انار", "میوه یاقوتی بهشت"),
                TargetWord("آبان", "ماه باران‌های پاییزی")
            ),
            bonusWords = listOf("بار", "ابر", "نار"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 139, chapterId = 6, chapterTitle = "دریای کاسپین",
            letters = listOf("م", "ه"),
            targetWords = listOf(
                TargetWord("مه", "ابر غلیظ بر بستر جنگل و جاده"),
                TargetWord("هم", "نشان همراهی و اشتراک")
            ),
            bonusWords = emptyList(), difficulty = LevelDifficulty.EASY
        ),
        Level(
            id = 140, chapterId = 6, chapterTitle = "دریای کاسپین",
            letters = listOf("ن", "س", "ی", "م"),
            targetWords = listOf(
                TargetWord("نسیم", "باد ملایم و خنک ساحلی"),
                TargetWord("سیم", "فلز نقره و رسانا"),
                TargetWord("مسین", "ظرف ساخته از مس"),
                TargetWord("مین", "گوهر درخشان یا تله")
            ),
            bonusWords = listOf("مس", "سن"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 141, chapterId = 6, chapterTitle = "دریای کاسپین",
            letters = listOf("ص", "د", "ف"),
            targetWords = listOf(
                TargetWord("صدف", "پوشش آهکی مرواریدهای ساحل"),
                TargetWord("صف", "خط مستقیم ایستادگان"),
                TargetWord("فدک", "باغ تاریخی پربرکت")
            ),
            bonusWords = listOf("دف"), difficulty = LevelDifficulty.EASY
        ),
        Level(
            id = 142, chapterId = 6, chapterTitle = "دریای کاسپین",
            letters = listOf("م", "ر", "و", "ا", "ر", "ی", "د"),
            targetWords = listOf(
                TargetWord("مروارید", "گوهر گرانبهای پنهان در دل صدف"),
                TargetWord("دیوار", "ستون محافظ خانه"),
                TargetWord("دیدار", "ملاقات دوستان پس از دوری"),
                TargetWord("رادیو", "دستگاه پخش امواج صدا"),
                TargetWord("داوری", "قضاوت عادلانه در میدان"),
                TargetWord("مرداد", "ماه گرم و پرمیوه تابستان")
            ),
            bonusWords = listOf("مرد", "رود", "یار"), difficulty = LevelDifficulty.EXPERT
        ),
        Level(
            id = 143, chapterId = 6, chapterTitle = "دریای کاسپین",
            letters = listOf("ش", "ن", "ا"),
            targetWords = listOf(
                TargetWord("شنا", "ورزش شناوری در امواج آبی"),
                TargetWord("نشان", "علامت و نشانه افتخار"),
                TargetWord("آشنا", "دوست قدیمی و شناخته‌شده")
            ),
            bonusWords = listOf("شن"), difficulty = LevelDifficulty.EASY
        ),
        Level(
            id = 144, chapterId = 6, chapterTitle = "دریای کاسپین",
            letters = listOf("غ", "و", "ا", "ص"),
            targetWords = listOf(
                TargetWord("غواص", "کاشف اعماق اقیانوس‌ها"),
                TargetWord("صاغ", "سالم و تندرست در ترکی"),
                TargetWord("غار", "شکاف کوهستانی"),
                TargetWord("صوت", "صدای رسا و آهنگین")
            ),
            bonusWords = listOf("غو", "صا"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 145, chapterId = 6, chapterTitle = "دریای کاسپین",
            letters = listOf("ن", "ه", "ن", "گ"),
            targetWords = listOf(
                TargetWord("نهنگ", "غول‌پیکرترین پستاندار اقیانوس"),
                TargetWord("گنه", "خطا و گناه در شعر"),
                TargetWord("نگه", "نگاه و دیده‌بانی"),
                TargetWord("هنگ", "واحد ارتشی بزرگ")
            ),
            bonusWords = listOf("نه", "گن"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 146, chapterId = 6, chapterTitle = "دریای کاسپین",
            letters = listOf("د", "ل", "ف", "ی", "ن"),
            targetWords = listOf(
                TargetWord("دلفین", "باهوش‌ترین و مهربان‌ترین پستاندار دریایی"),
                TargetWord("فندل", "میوه درخت فندق"),
                TargetWord("فیل", "حیوان عظیم‌الجثه خرطوم‌دار"),
                TargetWord("فنی", "تخصصی و دارای دانش فنی"),
                TargetWord("دفین", "پنهان‌شده در زیر خاک")
            ),
            bonusWords = listOf("دل", "دف"), difficulty = LevelDifficulty.HARD
        ),
        Level(
            id = 147, chapterId = 6, chapterTitle = "دریای کاسپین",
            letters = listOf("ل", "ن", "گ", "ر"),
            targetWords = listOf(
                TargetWord("لنگر", "تثبیت‌کننده کشتی در بندرگاه"),
                TargetWord("رنگ", "جلوه زیبای رنگین‌کمان"),
                TargetWord("گرن", "چرخش آسیاب آبی"),
                TargetWord("لگن", "ظرف گود شستشو")
            ),
            bonusWords = listOf("گل", "لر"), difficulty = LevelDifficulty.MEDIUM
        ),
        Level(
            id = 148, chapterId = 6, chapterTitle = "دریای کاسپین",
            letters = listOf("ف", "ا", "ن", "و", "س"),
            targetWords = listOf(
                TargetWord("فانوس", "راهنمای درخشان دریانوردان در شب"),
                TargetWord("افسون", "جادوی کلام زیبا"),
                TargetWord("سونا", "اتاق بخار و تندرستی"),
                TargetWord("سفان", "کشتی‌بان در زبان باستان"),
                TargetWord("وان", "ظرف شستشو یا شهر کهن")
            ),
            bonusWords = listOf("سوف", "فاس"), difficulty = LevelDifficulty.HARD
        ),
        Level(
            id = 149, chapterId = 6, chapterTitle = "دریای کاسپین",
            letters = listOf("ب", "ن", "د", "ر", "گ", "ا", "ه"),
            targetWords = listOf(
                TargetWord("بندرگاه", "پناهگاه امن پهلوگیری کشتی‌ها"),
                TargetWord("پرگار", "ابزار ترسیم دوایر منظم"),
                TargetWord("نگهدار", "محافظت‌کننده از اموال"),
                TargetWord("دربان", "نگهبان دروازه ورودی"),
                TargetWord("برهان", "دلیل روشن و منطقی"),
                TargetWord("آهنگر", "سازنده ابزارهای فولادی")
            ),
            bonusWords = listOf("بندر", "گناه", "راه"), difficulty = LevelDifficulty.EXPERT
        ),
        Level(
            id = 150, chapterId = 6, chapterTitle = "دریای کاسپین",
            letters = listOf("ا", "ق", "ی", "ا", "ن", "و", "س"),
            targetWords = listOf(
                TargetWord("اقیانوس", "پهنه بیکران آب‌های نیلگون زمین"),
                TargetWord("یاقوت", "سنگ سرخ قیمتی و معدنی"),
                TargetWord("قانون", "قواعد نظم‌بخش جامعه"),
                TargetWord("سونا", "گرمابه بخار و سلامتی"),
                TargetWord("قایق", "شناور سبک بر آب"),
                TargetWord("کاسپین", "دریاچه بی‌همتای شمال")
            ),
            bonusWords = listOf("وان", "سین", "نو"), difficulty = LevelDifficulty.EXPERT
        )
    )

    // Procedural Templates for infinite levels beyond level 150
    private val proceduralWordSets = listOf(
        Pair(
            listOf("د", "ا", "ن", "ش", "گ", "ا", "ه"),
            listOf(
                TargetWord("دانشگاه", "مهد علم، اندیشه و تخصص"),
                TargetWord("دانش", "آگاهی، علم و دانایی"),
                TargetWord("نگاه", "دیدن و تماشا کردن"),
                TargetWord("گناه", "خطا و لغزش در عمل"),
                TargetWord("شاد", "خوشحال و لبخندزنان"),
                TargetWord("گاه", "زمان و هنگام مناسب")
            )
        ),
        Pair(
            listOf("ب", "ز", "ر", "گ", "ر", "ا", "ه"),
            listOf(
                TargetWord("بزرگراه", "شاهراه وسیع عبور و مرور"),
                TargetWord("بزرگ", "عظیم، والامقام و شریف"),
                TargetWord("گراز", "حیوان قدرتمند جنگلی"),
                TargetWord("هزار", "عدد ده صد و بلبل خوشخوان"),
                TargetWord("برگ", "اندام سبز درختان"),
                TargetWord("راه", "طریق و مسیر زندگی")
            )
        ),
        Pair(
            listOf("ه", "ن", "ر", "م", "ن", "د"),
            listOf(
                TargetWord("هنرمند", "آفریننده زیبایی و هنر"),
                TargetWord("هنر", "خلاقیت و ذوق لطیف"),
                TargetWord("مرد", "انسان رشید و جوانمرد"),
                TargetWord("رند", "زیرک و وارسته از تعلقات"),
                TargetWord("مهر", "محبت و خورشید تابان"),
                TargetWord("هند", "سرزمین هفتاد و دو ملت")
            )
        ),
        Pair(
            listOf("ش", "ا", "د", "م", "ا", "ن"),
            listOf(
                TargetWord("شادمان", "مسرور و پر از انرژی مثبت"),
                TargetWord("آسمان", "سقف نیلگون و زیبا"),
                TargetWord("سامان", "نظم، ترتیب و امنیت"),
                TargetWord("شاد", "خندان و با نشاط"),
                TargetWord("دامان", "پای کوهسار و آغوش مادر"),
                TargetWord("نام", "شناسه و شهرت نیک")
            )
        ),
        Pair(
            listOf("س", "پ", "ا", "س", "گ", "ذ", "ا", "ر"),
            listOf(
                TargetWord("سپاسگزار", "قدردان نعمت‌ها و محبت‌ها"),
                TargetWord("پاسدار", "نگهبان ارزش‌های والا"),
                TargetWord("سرافراز", "سربلند و کامروا"),
                TargetWord("آسیاب", "دستگاه آرد کردن گندم"),
                TargetWord("گزارش", "شرح وقایع رخ‌داده"),
                TargetWord("پارس", "ایران‌زمین باستان")
            )
        ),
        Pair(
            listOf("ر", "و", "ز", "گ", "ا", "ر"),
            listOf(
                TargetWord("روزگار", "چرخش ایام و گذشت زمان"),
                TargetWord("گردو", "مغز آجیلی مقوی و سرشار از فسفر"),
                TargetWord("گودرز", "پهلوان سالخورده شاهنامه"),
                TargetWord("آرزو", "خواست قلبی و امید"),
                TargetWord("زار", "ناتوان یا زمین زراعی"),
                TargetWord("گوزن", "آهوی شاخ‌دار جنگل")
            )
        ),
        Pair(
            listOf("آ", "ف", "ت", "ا", "ب"),
            listOf(
                TargetWord("آفتاب", "خورشید عالم‌تاب و گرم"),
                TargetWord("تابان", "درخشان و نورافشان"),
                TargetWord("بافته", "تار و پود دستباف"),
                TargetWord("تاب", "شکیبایی و تاب خوردن"),
                TargetWord("آب", "مایه حیات همگان")
            )
        ),
        Pair(
            listOf("س", "ت", "ا", "ی", "ش"),
            listOf(
                TargetWord("ستایش", "حمد و سپاس پروردگار"),
                TargetWord("شایست", "سزاوار و لایق"),
                TargetWord("یاس", "گل سفید و معطر"),
                TargetWord("سایه", "پناهگاه خنک"),
                TargetWord("شست", "انگشت بزرگ دست")
            )
        )
    )

    fun getLevel(levelId: Int): Level {
        val handcrafted = handcraftedLevels.find { it.id == levelId }
        if (handcrafted != null) return handcrafted

        // Procedural generator for levels 151 and beyond
        val chapterId = (((levelId - 1) / 25) % chapters.size) + 1
        val chapter = chapters.find { it.id == chapterId } ?: chapters.last()
        val templateIndex = (levelId - 1) % proceduralWordSets.size
        val template = proceduralWordSets[templateIndex]

        return Level(
            id = levelId,
            chapterId = chapter.id,
            chapterTitle = "${chapter.title} (مرحله پیشرفته)",
            letters = template.first.shuffled(),
            targetWords = template.second,
            bonusWords = listOf("پند", "دل", "تن", "راز", "ساز"),
            difficulty = when {
                levelId < 30 -> LevelDifficulty.EASY
                levelId < 70 -> LevelDifficulty.MEDIUM
                levelId < 110 -> LevelDifficulty.HARD
                else -> LevelDifficulty.EXPERT
            }
        )
    }

    fun getTotalHandcraftedCount(): Int = handcraftedLevels.size

    fun getChapterForLevel(levelId: Int): Chapter {
        return chapters.find { levelId in it.startLevel..it.endLevel } ?: chapters.last()
    }

    // Daily Challenge Generator
    fun getDailyChallenge(dayOfYear: Int): Level {
        val dailyThemes = listOf(
            Pair(
                listOf("ف", "ر", "ه", "ن", "گ"),
                listOf(
                    TargetWord("فرهنگ", "تمدن، ادب و هویت ملی"),
                    TargetWord("هنر", "خلاقیت، زیبایی و ذوق"),
                    TargetWord("رنگ", "جلوه بصری نورها"),
                    TargetWord("رهن", "ضمانت و امانت مالی"),
                    TargetWord("فر", "شکوه و جلال باستانی")
                )
            ),
            Pair(
                listOf("د", "و", "س", "ت", "ی"),
                listOf(
                    TargetWord("دوستی", "پیوند عاطفی و محبت‌آمیز"),
                    TargetWord("دست", "عضو یاری‌رسان بدن"),
                    TargetWord("سوت", "صدای رسای داور"),
                    TargetWord("توس", "زادگاه حکیم فردوسی"),
                    TargetWord("سود", "منفعت و فایده نیک")
                )
            ),
            Pair(
                listOf("پ", "ی", "و", "ن", "د"),
                listOf(
                    TargetWord("پیوند", "اتصال و همبستگی جاودانه"),
                    TargetWord("پوند", "واحد پول بین‌المللی"),
                    TargetWord("نوید", "مژده و خبر خوش"),
                    TargetWord("دین", "آیین و راه و رسم"),
                    TargetWord("دیو", "موجود افسانه‌ای زورمند")
                )
            ),
            Pair(
                listOf("ک", "ه", "ک", "ش", "ا", "ن"),
                listOf(
                    TargetWord("کهکشان", "رود نقره‌ای ستارگان عالم"),
                    TargetWord("کاهش", "کم شدن و افت"),
                    TargetWord("نشان", "علامت و افتخار"),
                    TargetWord("شنا", "ورزش در آب‌های نیلگون"),
                    TargetWord("شاه", "فرمانروای دادگر")
                )
            )
        )
        val selected = dailyThemes[dayOfYear % dailyThemes.size]
        return Level(
            id = 9999 + dayOfYear,
            chapterId = 1,
            chapterTitle = "چالش روزانه کلمات",
            letters = selected.first.shuffled(),
            targetWords = selected.second,
            bonusWords = listOf("دیو", "پویا", "سود", "ساز"),
            difficulty = LevelDifficulty.HARD
        )
    }
}
