# Mobilní hra - Feed Me! (TAMZ2)

Mobilní aplikace pro android telefony Feed Me!, práce je určena jako projekt do předmětu TAMZ2.
Jedná se o 2D hru, kde postavička sbírá jídlo na obrazovce, její pohyb se ovládá gesty. Na jezení jídla má určitý časový limit, při snězení se zbývající čas zase zvýší na maximální limit. Při vypršení časomíry, snězení shnilého jídla nebo kolize s hranicemi obrazovky hra končí.
Součástí hry je menu, kde si hráč vybírá skin (skiny se odemykají získáváním určitého maximálního score), zobrazuje nejvyšší score (uložené do shared preferences), zobrazuje návod jak hru hrát a spouští hru samotnou.

Výsledek:
Aplikace má úspěšně implementovány veškeré věci, které jsou zmíněny výše. Ukládání dat o zvoleném skinu a skóre do SharedPreferences. Akce pro hlavní menu, zobrazení nejvyššího skóre, zvolení skinu, zobrazení návodu na hraní a hrací plochu samotnou.

## Kelvin Videa k projektu:
### Video 1
- ukázka kompletní hry po dohrání
- hráč má odemklé všechny skiny a může je libovolně měnit
- ukázka hlavního menu
- ukázka list view nejvyšších skóre
- ukázka návodu na hraní (how to play obrázky)
- ukázka výběru skinů
- ukázka hracího pole -> restart, smrt (kolize se stěnou, kolize se shnilým jídlem, vypršení limitu), jezení (navýšení score a nastavení limitu na 5s)

https://github.com/user-attachments/assets/2dd4c9a6-e523-40e4-9f3d-05cc3dbf18d3

### Video 2
- ukázka hry po prvním spuštění
- hráč nemá odemklé žádné skiny -> musí nahrát minimální skóre aby si skiny odemknul
- pokus o zvolení jiných skinů bez dostatečného skóre, skin nezvolen protože hráč musí minimální skóre alespoň jendou nahrát
- nahrání score minimálně 15 na odemknutí modrého skinu
- skóre přičteno do DB a zobrazeno v High Scores
- modrý skin úspěšně zlovel
- ukázka změněné ikony aplikace

https://github.com/user-attachments/assets/7f0369e4-8ac4-406e-b66f-aba200866ace
