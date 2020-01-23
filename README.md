# CryptoRPC
 
This is a cryptocurrency seminar for https://www.oss.unist.hr/ by Josip Skako.
We are using MS-SQL (T-SQL) database that are connecting with JAVA over JDBC driver.
We have 3 tables:
 * Users - table where users are stored
 * LastSearch - table where last block search results are stored
 * AddressBook - table where user save bitcoin addresses
 
User password and other details are encrypted into database and can't be easily readable.
We have user interactive login and registration form.
When user sing-in he can search blocks by height and depth. To connect on bicoin node we are using BitcoinJSONRPCClient library that can be found on: https://github.com/Polve/bitcoin-rpc-client/blob/master/src/main/java/wf/bitcoin/javabitcoindrpcclient/BitcoinJSONRPCClient.java
Last block is automatically loaded at user login with JSON - GSON library.

We can also make piechart for all searched blocks by their size.
When user hit "Search" button it automatically save results in database "LastSearch" so it can load it when user log-in next time.

We can sellect specific block and hit "List address" button. It will show us all used addresses in that block. We can save that addresss in our "Address Book" or explore it over link that opens in default internet browser. (May take some time to load all addresses)

In "Address Book" we can "Add" or "Delete" specific address. We can also use "QR generator" to genenrate QR code with specific address and amount.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
