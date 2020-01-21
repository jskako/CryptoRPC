CREATE TABLE [dbo].[BlockChain](
	F03ID int NOT NULL PRIMARY KEY,  -- ID
	F03UID int NOT NULL,  -- User ID
        F03HASH varchar(512) NOT NULL,    -- Hash
        F03PHASH varchar(512) NOT NULL,    -- PreviousHash
	F03DATA varchar(512) NOT NULL, 
	F03TS varchar(512) NOT NULL, -- Time Stamp
	F03NON varchar(512) NOT NULL, -- Nonce
	)

GO

ALTER TABLE [dbo].[BlockChain]  WITH CHECK ADD  CONSTRAINT [USER_POSTOJI_BC] FOREIGN KEY([F03UID])
REFERENCES [dbo].[Users] ([F01ID])
GO