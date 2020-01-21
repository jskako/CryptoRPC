CREATE TABLE [dbo].[Users](
	F01ID int NOT NULL PRIMARY KEY,  -- ID
	F01USR varchar(20) NOT NULL,    -- Username
	F01IME varchar(50) NOT NULL,    -- Ime 
	F01PRE varchar(50) NOT NULL,    -- Prezime 
	F01PWD varchar(256) NOT NULL,    -- Sifra
	F01EMA varchar(100) NOT NULL,    -- Mail
	F01DMR date NOT NULL,            -- Datum rodenja
	F01GRA varchar(50) NOT NULL,    -- Grad rodenja
	F01DRZ varchar(50) NOT NULL,    -- Drzava 
	F01ADR varchar(100) NOT NULL,    -- Adresa
	F01PBR int NOT NULL,             -- Postanski broj
	F01BRT varchar(50) NOT NULL,     -- Broj telefona
	F01DVK datetime,                 -- Datum i vrijeme kreiranja
	F01DVL datetime,                  -- Datum i vrijeme zadnjeg logiranja
	F01AKT int NOT NULL             -- Aktivnost
	)

GO