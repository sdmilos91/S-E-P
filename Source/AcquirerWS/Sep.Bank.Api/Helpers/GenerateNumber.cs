using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Sep.Bank.Api.Helpers
{
    public class GenerateNumber
    {
        private static readonly long LIMIT = 10000000000L;
        private static readonly DateTime Jan1st1970 = new DateTime(1970, 1, 1, 0, 0, 0, DateTimeKind.Utc);

        /// <summary>
        /// Generisanje desetocifrenog broja
        /// </summary>
        /// <param name="last">Prosledjuje se poslednji generisan broj zbog provere jedinstvenosti</param>
        /// <returns>Jedinstven desetocifren broj</returns>
        public static long GenerateTenDigitNumber(decimal last)
        {
            // 10 digits.
            decimal currentTimeMillis = CurrentTimeMillis();
            decimal id = currentTimeMillis % LIMIT;
            if (id <= last)
            {
                id = (last + 1) % LIMIT;
            }
            return (long)id;
        }

        private static long CurrentTimeMillis()
        {
            return (long)(DateTime.UtcNow - Jan1st1970).TotalMilliseconds;
        }
    }
}