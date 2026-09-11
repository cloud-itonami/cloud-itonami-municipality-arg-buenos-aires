(ns ordinance.facts
  "Municipal-ordinance compliance catalog for Buenos Aires -- the
  TWELFTH municipality-level entry (see cloud-itonami-municipality-jpn-tokyo,
  -usa-washington-dc, -gbr-london, -can-toronto, -deu-berlin, -fra-paris,
  -nld-amsterdam, -esp-madrid, -kor-seoul, -ita-roma, -aus-sydney for the
  first eleven) per ADR-2607141700 (cloud-itonami-compliance-fact-federation).

  Every entry cites an OFFICIAL boletinoficial.buenosaires.gob.ar (the
  Autonomous City of Buenos Aires' own official gazette norm database)
  URL -- never fabricated. An ordinance not in this table has NO
  spec-basis, full stop; extend `catalog`, do not invent an id/url/number.

  The city's direct PDF republication of Ley 6017 rendered with a
  font-subsetting artifact worse than usual for this family -- even the
  law's own title was illegible, only the 'Gobierno de la Ciudad
  Autónoma de Buenos Aires' header rendered. Both entries below were
  instead directly WebFetch-verified against
  boletinoficial.buenosaires.gob.ar's own HTML norm pages, which
  rendered fully and state the norm number and publication date
  explicitly.")

(def catalog
  "municipality-slug -> vector of ordinance entries."
  {"buenos-aires"
   [{:ordinance/id "buenos-aires.codigo-contravencional-ley1472"
     :ordinance/title "Código Contravencional de la Ciudad Autónoma de Buenos Aires"
     :ordinance/municipality "buenos-aires"
     :ordinance/country "ARG"
     :ordinance/kind :ordinance
     :ordinance/number "Ley 1472"
     :ordinance/url "https://boletinoficial.buenosaires.gob.ar/normativaba/norma/62598"
     :ordinance/url-provenance :official-boletinoficial-buenosaires
     :ordinance/enacted-date "2004-10-28"
     :ordinance/retrieved-at "2026-07-15"
     :ordinance/topic #{:public-order}}
    {:ordinance/id "buenos-aires.ley-acceso-informacion-104"
     :ordinance/title "Ley de Acceso a la Información"
     :ordinance/municipality "buenos-aires"
     :ordinance/country "ARG"
     :ordinance/kind :ordinance
     :ordinance/number "Ley 104"
     :ordinance/url "https://boletinoficial.buenosaires.gob.ar/normativaba/norma/982"
     :ordinance/url-provenance :official-boletinoficial-buenosaires
     :ordinance/enacted-date "1998-12-17"
     :ordinance/retrieved-at "2026-07-15"
     :ordinance/topic #{:information-disclosure :transparency}}]})

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
      :note (str "cloud-itonami-municipality-arg-buenos-aires Wave 0 (ADR-2607141700): "
                 (count (get catalog "buenos-aires")) " Buenos Aires entries seeded "
                 "with an official boletinoficial.buenosaires.gob.ar citation. "
                 "Extend `ordinance.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [muni topic]
  (filterv #(contains? (:ordinance/topic %) topic) (spec-basis muni)))
