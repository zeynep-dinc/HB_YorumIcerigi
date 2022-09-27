Feature: Test 1

  Background: Ana step
    * Kullanicinin hepsiburada "ANASAYFA" oldugu teyit edilir

    Scenario Template: "<urunAdi>" icin arama yap ve ilk yorumu begen
      * Arama cubuguna "<urunAdi>" yaz ve yaziyi dogrula
      * "ENTER" tusuna bas
#      * Arama cubugunda "<urunAdi>" degerinin aratildigini dogrula
      * Ilk urunun detayini ac
      * Son tabi ac ilk tabi kapat
      * Degerlendirme yazisina tikla
      * "PAGE_DOWN" tusuna bas
      * Ilk yorumun icerigini al
      * Ilk yorum icin begen butonuna tikla
      * Ekrandaki Tesekkur Ederiz yazisini dogrula
      Examples:
        | urunAdi |
        | apple   |
        | samsung |