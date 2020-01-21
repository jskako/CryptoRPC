CREATE TABLE [dbo].[CryptoKey](
	F02ID int NOT NULL PRIMARY KEY,  -- ID
	F02UID int NOT NULL,  -- User ID
    F02PKEY varchar(512) NOT NULL,    -- Private key
    F02KEY varchar(512) NOT NULL,    -- Public key
	F02PRIM decimal(13,2) NULL, -- Ukupno primljenih coinsa
	F02POSL decimal(13,2) NULL, -- Ukupno poslanih coinsa
	F02UKUP decimal(13,2) NULL, -- Ukupno trenutno stanje
	)

GO

ALTER TABLE [dbo].[CryptoKey]  WITH CHECK ADD  CONSTRAINT [USER_POSTOJI] FOREIGN KEY([F02UID])
REFERENCES [dbo].[Users] ([F01ID])
GO