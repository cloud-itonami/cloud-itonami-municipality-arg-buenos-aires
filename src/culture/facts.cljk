(ns culture.facts
  "Regional-culture catalog for Buenos Aires -- local dishes, protected
  products, beverages, festivals and heritage sites, piggybacked
  onto this municipality compliance repo per ADR-2607171400
  (cloud-itonami-municipality-culture-catalog, in com-junkawasaki/root),
  sibling namespace to `ordinance.facts` (ADR-2607141700).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "municipality-slug -> vector of culture entries."
  {"buenos-aires"
   [{:culture/id "buenos-aires.dish.asado"
     :culture/name "Asado"
     :culture/municipality "buenos-aires"
     :culture/country "ARG"
     :culture/kind :dish
     :culture/summary "Barbecue technique and social event of South America, especially Argentina and Uruguay; a national symbol of Argentina, widely practiced in Buenos Aires."
     :culture/url "https://en.wikipedia.org/wiki/Asado"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "buenos-aires.dish.milanesa"
     :culture/name "Milanesa"
     :culture/municipality "buenos-aires"
     :culture/country "ARG"
     :culture/kind :dish
     :culture/summary "Breaded cutlet considered a quintessential national dish of Argentina; the napolitana variant is popularly said to have originated in Buenos Aires in the 1940s."
     :culture/url "https://en.wikipedia.org/wiki/Milanesa"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "buenos-aires.dish.choripan"
     :culture/name "Choripan"
     :culture/name-local "Choripán"
     :culture/municipality "buenos-aires"
     :culture/country "ARG"
     :culture/kind :dish
     :culture/summary "Chorizo sandwich popular in Argentina and neighboring countries, sold by street vendors in Buenos Aires since at least the 1920s, including at Plaza de Mayo."
     :culture/url "https://en.wikipedia.org/wiki/Chorip%C3%A1n"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "buenos-aires.dish.fugazza"
     :culture/name "Fugazza"
     :culture/municipality "buenos-aires"
     :culture/country "ARG"
     :culture/kind :dish
     :culture/summary "Common type of Argentine pizza originating in Buenos Aires: a thick crust topped with onions and sometimes olives, with a cheese variant called fugazza con queso."
     :culture/url "https://en.wikipedia.org/wiki/Fugazza"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "buenos-aires.product.dulce-de-leche"
     :culture/name "Dulce de leche"
     :culture/municipality "buenos-aires"
     :culture/country "ARG"
     :culture/kind :product
     :culture/summary "Milk-based confection widely consumed in Argentina, which in 2003 attempted to declare it intangible cultural heritage; origin theories vary and are contested across Latin America."
     :culture/url "https://en.wikipedia.org/wiki/Dulce_de_leche"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "buenos-aires.beverage.mate"
     :culture/name "Mate"
     :culture/municipality "buenos-aires"
     :culture/country "ARG"
     :culture/kind :beverage
     :culture/summary "Caffeine-rich herbal infusion that is the national beverage of Argentina, Paraguay and Uruguay."
     :culture/url "https://en.wikipedia.org/wiki/Mate_(drink)"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "buenos-aires.festival.buenos-aires-international-book-fair"
     :culture/name "Buenos Aires International Book Fair"
     :culture/name-local "Feria Internacional del Libro de Buenos Aires"
     :culture/municipality "buenos-aires"
     :culture/country "ARG"
     :culture/kind :festival
     :culture/summary "One of the top five book expos in the world, held every April in Buenos Aires since 1975, drawing around 1.2 million visitors."
     :culture/url "https://en.wikipedia.org/wiki/Buenos_Aires_International_Book_Fair"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "buenos-aires.heritage.tango"
     :culture/name "Tango"
     :culture/municipality "buenos-aires"
     :culture/country "ARG"
     :culture/kind :heritage
     :culture/summary "Partner dance and music that originated in the 1880s along the Rio de la Plata; inscribed on the UNESCO Intangible Cultural Heritage Lists in 2009 on a joint Argentina-Uruguay proposal."
     :culture/url "https://en.wikipedia.org/wiki/Tango"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "buenos-aires.heritage.teatro-colon"
     :culture/name "Teatro Colón"
     :culture/municipality "buenos-aires"
     :culture/country "ARG"
     :culture/kind :heritage
     :culture/summary "Historic opera house in Buenos Aires, open since 1908, renowned for its acoustics and ranked among the world's best opera houses."
     :culture/url "https://en.wikipedia.org/wiki/Teatro_Col%C3%B3n"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "buenos-aires.heritage.caminito"
     :culture/name "Caminito"
     :culture/municipality "buenos-aires"
     :culture/country "ARG"
     :culture/kind :heritage
     :culture/summary "Street museum and traditional alley in the La Boca neighborhood of Buenos Aires, about 100 metres long, which inspired the famous 1926 tango composition of the same name."
     :culture/url "https://en.wikipedia.org/wiki/Caminito"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [muni] (get catalog muni))

(defn coverage
  ([] (coverage (keys catalog)))
  ([munis]
   (let [have (filter catalog munis)
         missing (remove catalog munis)]
     {:requested (count munis)
      :covered (count have)
      :covered-municipalities (vec (sort have))
      :missing-municipalities (vec (sort missing))
      :note (str "cloud-itonami-municipality-arg-buenos-aires culture catalog "
                 "(ADR-2607171400): " (count (get catalog "buenos-aires"))
                 " Buenos Aires entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [muni kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis muni)))
