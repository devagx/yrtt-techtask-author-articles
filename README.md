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
