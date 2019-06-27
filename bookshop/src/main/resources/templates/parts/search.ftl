<#macro search path>
    <form action="${path}" method="get">
        <li>Choose criteria of search:
            <input type="radio"  checked name="search" value="genre"> Genre
            <input type="radio" name="search" value="author"> Author
        </li>
        <input name="param" type="text" size="70" class="textField"> <br>
        <input name="submit" type="submit" class="submit mid" value="Search">
    </form>
</#macro>