package ok.work.etoroapi.controller

import ok.work.etoroapi.watchlist.Asset
import ok.work.etoroapi.watchlist.EtoroAsset
import ok.work.etoroapi.watchlist.Watchlist
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

data class WatchAssetRequest(val param: String) {
}

@RestController
@RequestMapping("/watchlist")
class WatchlistController {

    @Autowired
    lateinit var watchlist: Watchlist

    @GetMapping
    fun getWatchlist(): List<Asset> {
        return watchlist.watchlist()
    }

    @PutMapping(value = ["/byName"])
    fun watchAssetByName(@RequestBody request: WatchAssetRequest): MutableMap<String, Asset> {
        return watchlist.addAssetToWatchlistByName(request.param)
    }

    @PutMapping(value = ["/byId"])
    fun watchAssetById(@RequestBody request: WatchAssetRequest): MutableMap<String, Asset> {
        return watchlist.addAssetToWatchlistById(request.param)
    }

}
