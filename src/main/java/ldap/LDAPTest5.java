package ldap;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

public class LDAPTest5 {

  public boolean test(String user, String pass, String domainName, DirContext ctx)
      throws NamingException {

    String tmp = user + "_USER";
    user = tmp + ".old";
    String saltedPassword = pass + "%!";
    String filter = "(&(uid=" + user + ")(userPassword=" + saltedPassword + "))";

    NamingEnumeration<SearchResult> results = ctx.search("ou=system", filter, new SearchControls());
    return results.hasMore();
  }
}
