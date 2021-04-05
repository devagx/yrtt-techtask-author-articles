# yrtt-techtask-author-articles

<p>Write an <em>HTTP GET</em> method to retrieve information from an articles' database. The query response is paginated and can be further accessed by appending to the query string &amp;<em>page=num</em> where <em>num</em> is the page number.</p>
 

<p>Given a string of author<em>, getArticleTitles</em> must perform the following tasks:</p>

<ol>
</ol>

<ol>
	<li>Query <em>https://jsonmock.hackerrank.com/api/articles?author=&lt;authorName&gt;&amp;page=&lt;num&gt; </em>(replace <em>&lt;authorName&gt; and &lt;num&gt;</em>). </li>
	<li>Initialize the <em>titles</em> array to store a list of string elements.</li>
	<li>Store the name of each article returned in the <em>data</em> field to the <em>titles</em> array using the following logic:
	<ul>
		<li>If <em>title</em> is not null, use <em>title</em> as the name.</li>
		<li>If <em>title </em>is null, and story title is not null, use <em>story_title</em> as the name. </li>
		<li>If both <em>title</em> and <em>story_title</em> are null, ignore the article.</li>
	</ul>
	</li>
	<li>Based on the <em>total_pages </em>count, fetch all the data (pagination) and perform step 3 for each.</li>
	<li>Return the array of titles.</li>
</ol>

<p> </p>

<p>The query response from the website is a JSON response with the following five fields:</p>

<ul>
	<li>
<em>page</em>: The current page.</li>
	<li>
<em>per_page</em>: The maximum number of results per page.</li>
	<li>
<em>total</em>: The total number of records in the search result.</li>
	<li>
<em>total_pages</em>: The total number of pages that must be queried to get all the results.</li>
	<li>
<em>data</em>: An array of JSON objects containing article information</li>
</ul>

<p> </p>

<p class="section-title">Function Description</p>

<p>Complete the function <em>getArticleTitles</em> in the editor below.</p>

<p> </p>

<p><em>getArticleTitles</em> has the following parameter(s):</p>

<p>    <em>string author:</em>  the author string to search on</p>

<p>Returns:</p>

<p>    <em>string[]:</em> a list of the articles as described</p>

<p> </p>

<details><summary class="section-title">Schema</summary>

<div class="collapsable-details">
<p> </p>

<p>You are provided 1 table: ARTICLES. </p>

<table class="database-table">
	<tbody>
		<tr>
			<th colspan="100">ARTICLES</th>
		</tr>
		<tr>
			<td>Name</td>
			<td>Type</td>
			<td>Description</td>
		</tr>
		<tr>
			<td>title</td>
			<td>STRING</td>
			<td class="description">This is the first column. It is the title of the article</td>
		</tr>
		<tr>
			<td>url</td>
			<td>STRING</td>
			<td class="description">URL of the article</td>
		</tr>
		<tr>
			<td>author</td>
			<td>STRING</td>
			<td class="description">the author name of the article </td>
		</tr>
		<tr>
			<td>num_comments</td>
			<td>LONG</td>
			<td class="description">total number of comments  </td>
		</tr>
		<tr>
			<td>story_id</td>
			<td>LONG</td>
			<td class="description">unique identifier number for the article</td>
		</tr>
		<tr>
			<td>story_title</td>
			<td>STRING</td>
			<td class="description">an additional title for the article</td>
		</tr>
		<tr>
			<td>story_url</td>
			<td>STRING</td>
			<td class="description">an additional URL for the article</td>
		</tr>
		<tr>
			<td>parent_id</td>
			<td>LONG</td>
			<td class="description">unique identifier number of the parent article</td>
		</tr>
		<tr>
			<td>created_at</td>
			<td>LONG</td>
			<td class="description">created time of the article</td>
		</tr>
	</tbody>
</table>
</div>
</details>

<details><summary class="section-title">Sample Case 0</summary>

<div class="collapsable-details">
<p class="section-title">Sample Input For Custom Testing</p>

<pre>
STDIN     Function
-----     --------
epaga  →  author = 'epaga'
</pre>

<p class="section-title"> </p>

<p class="section-title">Sample Output</p>

<pre>
A Message to Our Customers
Apple’s declining software quality
</pre>

<p class="section-title">Explanation</p>

<table class="database-table">
	<tbody>
		<tr>
			<th colspan="104">ARTICLES</th>
		</tr>
		<tr>
			<td>title</td>
			<td>url</td>
			<td>author</td>
			<td>num_comments</td>
			<td>story_id</td>
			<td>story_title</td>
			<td>story_url</td>
		</tr>
		<tr>
			<td>
			<p>A Message to Our Customers</p>
			</td>
			<td>null</td>
			<td>
			<p>epaga</p>
			</td>
			<td>
			<p>967</p>
			</td>
			<td>null</td>
			<td>null</td>
			<td>null</td>
		</tr>
		<tr>
			<td>
			<p>Google Is Eating Our Mail</p>
			</td>
			<td>null</td>
			<td>saintamh</td>
			<td>
			<p>685</p>
			</td>
			<td>null</td>
			<td>null</td>
			<td>null</td>
		</tr>
		<tr>
			<td>
			<p>null</p>
			</td>
			<td>
			<p>null</p>
			</td>
			<td>epaga</td>
			<td>705</td>
			<td>null</td>
			<td>Apple’s declining software quality</td>
			<td>null</td>
		</tr>
	</tbody>
</table>
</div>
</details>

<details><summary class="section-title">Sample Case 1</summary>

<div class="collapsable-details">
<p class="section-title">Sample Input For Custom Testing</p>

<pre>
STDIN        Function
-----        --------
saintamh  →  author = 'saintamh'</pre>

<p class="section-title">Sample Output</p>

<pre>
Google Is Eating Our Mail</pre>

<p class="section-title">Explanation</p>

<table class="database-table">
	<tbody>
		<tr>
			<th colspan="104">ARTICLES</th>
		</tr>
		<tr>
			<td>title</td>
			<td>url</td>
			<td>author</td>
			<td>num_comments</td>
			<td>story_id</td>
			<td>story_title</td>
			<td>story_url</td>
		</tr>
		<tr>
			<td>
			<p>A Message to Our Customers</p>
			</td>
			<td>null</td>
			<td>
			<p>epaga</p>
			</td>
			<td>
			<p>967</p>
			</td>
			<td>null</td>
			<td>null</td>
			<td>null</td>
		</tr>
		<tr>
			<td>
			<p>Google Is Eating Our Mail</p>
			</td>
			<td>null</td>
			<td>saintamh</td>
			<td>
			<p>685</p>
			</td>
			<td>null</td>
			<td>null</td>
			<td>null</td>
		</tr>
		<tr>
			<td>
			<p>null</p>
			</td>
			<td>
			<p>null</p>
			</td>
			<td>epaga</td>
			<td>705</td>
			<td>null</td>
			<td>Apple’s declining software quality</td>
			<td>null</td>
		</tr>
	</tbody>
</table>
</div>
</details>
</div>
